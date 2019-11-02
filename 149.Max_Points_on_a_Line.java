class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 1) return 1;
        int max = 2;
        for (int i = 0; i < points.length; i++){
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int overlap = 1;
            int localmax = 0;
            for (int j = i+1; j < points.length; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0){
                    overlap++;
                    continue;
                }
                else if (dx == 0){
                    dy = 1;
                }
                else if (dy == 0){
                    dx = 1;
                }
                else{
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                }
                if (!map.containsKey(dx)){
                    map.put(dx, new HashMap<Integer, Integer>());
                }
                map.get(dx).put(dy, map.get(dx).getOrDefault(dy, 0)+1);
                localmax = Math.max(localmax, map.get(dx).get(dy));
            }
            max = Math.max(max, localmax+overlap);
        }
        return max;
    }
    
    private int gcd(int x, int y){
        if (y == 0) return x;
        return gcd(y, x%y);
    }
}