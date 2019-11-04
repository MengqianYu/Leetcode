class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (i==j){
                    dp[i][j] = true;
                }
                else if (s.charAt(i) == s.charAt(j)){
                    if (i+1 == j){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] |= dp[i+1][j-1];
                    }
                }
                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}