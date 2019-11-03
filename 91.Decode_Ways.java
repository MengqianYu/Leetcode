class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - '0';
            if (curr != 0){
                dp[i+1] += dp[i];
            }
            if (i>0){
                int prev = s.charAt(i-1) - '0';
                int num = prev*10 + curr;
                if (num <= 26 && num > 0 && prev != 0){
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[s.length()];
    }
}