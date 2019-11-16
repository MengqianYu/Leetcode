class Solution {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] != 0){
                    num++;
                }
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()){
            int size = queue.size();
            num -= size;
            if (num == 0) break;
            for (int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                if (row > 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    queue.offer(new int[]{row-1, col});
                }
                if (row+1 < m && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    queue.offer(new int[]{row+1, col});
                }
                if (col > 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    queue.offer(new int[]{row, col-1});
                }
                if (col+1 < n && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    queue.offer(new int[]{row, col+1});
                }
            }
            res++;
        }
        if (num != 0) return -1;
        return res;
    }
}