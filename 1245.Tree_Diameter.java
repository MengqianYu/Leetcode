class Solution {
    int max = 0;
    Map<Integer, Map<Integer, Integer>> pathmap;
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        pathmap = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            if (!map.containsKey(edges[i][0])){
                map.put(edges[i][0], new ArrayList<Integer>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            if (!map.containsKey(edges[i][1])){
                map.put(edges[i][1], new ArrayList<Integer>());
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }
       // boolean[] visited = new boolean[map.size()];
        for (int i : map.keySet()){
            maxPath(map, i, -1);
        }
        return max;
    }
    
    private int maxPath(Map<Integer, List<Integer>> map, int curr, int prev){
        if (pathmap.containsKey(curr) && pathmap.get(curr).containsKey(prev)) return pathmap.get(curr).get(prev);
        int res = 0;
        for (int i : map.get(curr)){
            if (i == prev) continue;
            res = Math.max(res, maxPath(map, i, curr)+1);
        }
        max = Math.max(max, res);
        //System.out.println(curr + " " + res);
        if (!pathmap.containsKey(curr)){
            pathmap.put(curr, new HashMap<Integer, Integer>());
        }
        pathmap.get(curr).put(prev, res);
        return res;
    }
}