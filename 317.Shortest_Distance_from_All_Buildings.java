class Solution {
    public int shortestDistance(int[][] grid) {
        int numBuildings = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int[][] buildingsReached = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    numBuildings++;
                    Queue<int[]> queue = new LinkedList<>();
                    int[][] dis = new int[grid.length][grid[0].length];
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()){
                        int[] curr = queue.poll();
                        int row = curr[0];
                        int col = curr[1];
                        if (grid[row][col] == 0){
                            buildingsReached[row][col]++;
                            res[row][col] += dis[row][col];
                        }
                        if (row > 0 && grid[row-1][col] == 0 && dis[row-1][col] == 0){
                            dis[row-1][col] = dis[row][col]+1;
                            queue.offer(new int[]{row-1, col});
                        }
                        if (row+1 < m && grid[row+1][col] == 0 && dis[row+1][col] == 0){
                            dis[row+1][col] = dis[row][col]+1;
                            queue.offer(new int[]{row+1, col});
                        }
                        if (col > 0 && grid[row][col-1] == 0 && dis[row][col-1] == 0){
                            dis[row][col-1] = dis[row][col]+1;
                            queue.offer(new int[]{row, col-1});
                        }
                        if (col+1 < n && grid[row][col+1] == 0 && dis[row][col+1] == 0){
                            dis[row][col+1] = dis[row][col]+1;
                            queue.offer(new int[]{row, col+1});
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        boolean reachable = false;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0 && buildingsReached[i][j] == numBuildings){
                    reachable = true;
                    min = Math.min(min, res[i][j]);
                }
            }
        }
        if (reachable) return min;
        return -1;
    }
}