class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int count = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (matrix[i-1][j-1] == 0) continue;
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                dp[i][j]++;
                count+=dp[i][j];
            }
        }
        return count;
    }
}