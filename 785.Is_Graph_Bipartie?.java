class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++){
            if (colors[i] == 0 && !dfs(graph, colors, i, 1))
                return false;
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int node, int color){
        if (colors[node] != 0){
            if (colors[node] != color) return false;
            else return true;
        }
        colors[node] = color;
        for (int i = 0; i < graph[node].length; i++){
            if (!dfs(graph, colors, graph[node][i], -color)) return false;
        }
        return true;
    }
}