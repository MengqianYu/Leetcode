class Solution {
    int num;
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        num = n;
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++){
            union(edges[i][0], edges[i][1]);
        }
        return num;
    }
    
    private void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if (px != py){
            parent[py] = px;
            num--;
        }
    }
    
    private int find(int x){
        if (parent[x] == x) return x;
        int p = find(parent[x]);
        parent[x] = p;
        return p;
    }
}