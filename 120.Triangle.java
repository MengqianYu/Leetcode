class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        if (triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        dp[0][0] = triangle.get(0).get(0);
        int min = dp[0][0];
        for (int i = 1; i < triangle.size(); i++){
            min = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++){
                dp[i][j] = Integer.MAX_VALUE;
                if (j < triangle.get(i-1).size())
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + triangle.get(i).get(j));
                if (j > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + triangle.get(i).get(j));
                }
                min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }
}