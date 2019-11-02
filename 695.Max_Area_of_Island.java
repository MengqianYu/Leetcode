class Solution {
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        max = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    int area = 0;
                    int[] pos = new int[]{i, j};
                    queue.offer(pos);
                    while (!queue.isEmpty()){
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];
                        if (grid[x][y] == 0) continue;
                        area++;
                        grid[x][y] = 0;
                        if (x > 0){
                            queue.offer(new int[]{x-1, y});
                        }
                        if (x+1 < grid.length){
                            queue.offer(new int[]{x+1, y});
                        }
                        if (y > 0){
                            queue.offer(new int[]{x, y-1});
                        }
                        if (y+1 < grid[0].length){
                            queue.offer(new int[]{x, y+1});
                        }
                    }
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
}