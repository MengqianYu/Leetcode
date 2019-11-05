class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone:stones) sum += stone;
        boolean[][] dp = new boolean[stones.length+1][sum+1];
        dp[0][0] = true;
        for (int i = 1; i <= stones.length; i++){
            for (int j = 0; j <= sum; j++){
                dp[i][j] = (j>=stones[i-1] && dp[i-1][j-stones[i-1]]) || dp[i-1][j];
            }
        }
        int largest = 0;
        for (int i = sum/2; i >= 0; i--){
            if (dp[stones.length][i]){
                largest = i;
                break;
            }
        }
        return sum-2*largest;
    }
}