class Solution {
    public int numDistinctIslands(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        if (grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    //queue.offer(new int[]{i, j});
                    StringBuilder sb = new StringBuilder();
                    /*while (!queue.isEmpty()){
                        int[] curr = queue.poll();
                        sb.append((curr[0]-i) + "" + (curr[1]-j));
                        grid[curr[0]][curr[1]] = 0;
                        if (curr[0] + 1 < grid.length && grid[curr[0]+1][curr[1]] == 1){
                            queue.offer(new int[]{curr[0] + 1, curr[1]});
                        }
                        if (curr[0] > 0 && grid[curr[0]-1][curr[1]] == 1){
                            queue.offer(new int[]{curr[0]-1, curr[1]});
                        }
                        if (curr[1] + 1 < grid[0].length && grid[curr[0]][curr[1]+1] == 1){
                            queue.offer(new int[]{curr[0], curr[1]+1});
                        }
                        if (curr[1] > 0 && grid[curr[0]][curr[1]-1] == 1){
                            queue.offer(new int[]{curr[0], curr[1]-1});
                        }
                    }*/
                    
                    //tle with queue????
                    dfs(grid, i, j, i, j, sb);
                    String s = sb.toString();
                    set.add(s);
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int[][] grid, int i, int j, int start_i, int start_j, StringBuilder sb){
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append((i-start_i) + "" + (j-start_j));
        dfs(grid, i+1, j, start_i, start_j, sb);
        dfs(grid, i-1, j, start_i, start_j, sb);
        dfs(grid, i, j+1, start_i, start_j, sb);
        dfs(grid, i, j-1, start_i, start_j, sb);
    }
}