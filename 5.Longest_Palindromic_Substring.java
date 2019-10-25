class Solution {
    public String longestPalindrome(String s) {
        int lo = 0;
        int hi = 0;
        int length = s.length();
        if (length == 0) return "";
        boolean[][] dp = new boolean[length][length];
        for (int i = length-1; i >= 0; i--){ 
            dp[i][i] = true;
            for (int j = i+1; j < length; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] || (i+1 == j);
                    if (dp[i][j] && j-i > hi-lo){
                        hi = j;
                        lo = i;
                    }
                }
            }
        }
        return s.substring(lo, hi+1);
    }
}