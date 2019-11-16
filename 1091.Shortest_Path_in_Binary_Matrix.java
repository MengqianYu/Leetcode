class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                if (row == m-1 && col == n-1){
                    return res;
                }
                addToQueue(grid, queue, row-1, col);
                addToQueue(grid, queue, row-1, col-1);
                addToQueue(grid, queue, row-1, col+1);
                addToQueue(grid, queue, row, col-1);
                addToQueue(grid, queue, row, col+1);
                addToQueue(grid, queue, row+1, col-1);
                addToQueue(grid, queue, row+1, col);
                addToQueue(grid, queue, row+1, col+1);
            }
        }
        return -1;
    }
    
    private void addToQueue(int[][] grid, Queue<int[]> queue, int row, int col){
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0){
            grid[row][col] = 1;
            queue.offer(new int[]{row, col});
        }
    }
}