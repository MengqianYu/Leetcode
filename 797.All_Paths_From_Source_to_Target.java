class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        if (graph.length == 0) return res;
        route.add(0);
        dfs(visited, res, graph, route);
        return res;
    }
    public void dfs(boolean[] visited, List<List<Integer>> res, int[][] graph, List<Integer> route){
        int curr = route.get(route.size()-1);
        if (curr == graph.length-1){
            List<Integer> list = new ArrayList<>();
            list.addAll(route);
            res.add(list);
            return;
        }
        int[] neighbors = graph[curr];
        visited[curr] = true;
        for (int next:neighbors){
            if (!visited[next]){
                route.add(next);
                dfs(visited, res, graph, route);
            }
            route.remove(route.size()-1);
        }
        visited[curr] = false;
    }
}