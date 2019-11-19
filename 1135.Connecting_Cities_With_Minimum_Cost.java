class Solution {
    int[] parent;
    int cnt;
    public int minimumCost(int N, int[][] connections) {
        parent = new int[N+1];
        Arrays.sort(connections, new Comparator<int[]>(){
            public int compare(int[] x, int[] y){
                return x[2] - y[2];
            }
        });
        for (int i = 1; i <= N; i++){
            parent[i] = i;
        }
        cnt = N;
        int res = 0;
        for (int[] connection: connections){
            int city1 = connection[0];
            int city2 = connection[1];
            if (find(city1) != find(city2)){
                merge(city1, city2);
                res += connection[2];
            }
        }
        if (cnt != 1) return -1;
        return res;
    }
    
    private int find(int x){
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private void merge(int x, int y){
        int px = find(x);
        int py = find(y);
        if (px != py){
            cnt--;
            parent[py] = px;
       }
    }
}