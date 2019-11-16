class Solution {
    int res = 0;
    public int uniquePathsIII(int[][] grid) {
        if (grid.length == 0) return 0;
        int starti = 0;
        int startj = 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    starti = i;
                    startj = j;
                }
                if (grid[i][j] == 0){
                    cnt++;
                }
            }
        }
        dfs(grid, starti, startj, cnt);
        return res;
    }
    
    private void dfs(int[][] grid, int row, int col, int cnt){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1){
            return;
        }
        if (grid[row][col] == 2){
            if (cnt == 0){
                res++;
            }
            return;
        }
        if (grid[row][col] == 0){
            cnt--;
        }
        grid[row][col] = -1;
        dfs(grid, row+1, col, cnt);
        dfs(grid, row-1, col, cnt);
        dfs(grid, row, col+1, cnt);
        dfs(grid, row, col-1, cnt);
        grid[row][col] = 0;
    }
}