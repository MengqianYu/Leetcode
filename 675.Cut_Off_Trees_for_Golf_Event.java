class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->forest.get(x[0]).get(x[1])- forest.get(y[0]).get(y[1]));
        for (int i = 0; i < forest.size(); i++){
            List<Integer> list = forest.get(i);
            for (int j = 0; j < list.size(); j++){
                if (list.get(j) > 1){
                    pq.offer(new int[]{i, j});
                }
            }
        }
        int[] start = new int[]{0, 0};
        int res = 0;
        while (!pq.isEmpty()){
            int[] end = pq.poll();
            int steps = minSteps(forest, start, end);
            if (steps == -1){
                return -1;
            }
            res += steps;
            start = end;
        }
        return res;
    }
    
    private int minSteps(List<List<Integer>> forest, int[] start, int[] end){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                if (row == end[0] && col == end[1]){
                    return res;
                }
                for (int[] dir : dirs){
                    int nr = row+dir[0];
                    int nc = col+dir[1];
                    if (nr >= 0 && nr < m && nc >= 0  && nc < n && forest.get(nr).get(nc) != 0 && !visited[nr][nc]){
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}