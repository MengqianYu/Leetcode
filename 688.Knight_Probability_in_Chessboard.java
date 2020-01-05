class Solution {
    double[][][] dp;
    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[K+1][N][N];
        int[][] dir = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                dp[0][i][j] = 1.0;
            }
        }
        for (int i = 1; i <= K; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    for (int p = 0; p < 8; p++){
                        int nr = j + dir[p][0];
                        int nc = k + dir[p][1];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N){
                            dp[i][j][k] += 0.125 * dp[i-1][nr][nc];
                        }
                    }
                }
            }
        }
        return dp[K][r][c];
    }
    
}