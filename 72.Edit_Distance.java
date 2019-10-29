class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for (int i = 0; i <= word1.length(); i++){
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++){
            dp[0][i] = i;
        }
        for (int i = 0; i < word1.length(); i++){
            for (int j = 0; j < word2.length(); j++){
                int replacecost = 0;
                if (word1.charAt(i) != word2.charAt(j)){
                    replacecost = 1;
                }
                dp[i+1][j+1] = Math.min(dp[i][j] + replacecost, Math.min(dp[i+1][j] + 1, dp[i][j+1] + 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}