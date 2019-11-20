class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[len+1];
        for (int i = 1; i <= len; i++){
            dp[i] = Math.min(dp[i-1] + costs[0], findPrev(days, dp, i-1, 7, costs[1]));
            dp[i] = Math.min(dp[i], findPrev(days, dp, i-1, 30, costs[2]));
        }
        return dp[len];
    }
    
    private int findPrev(int[] days, int[] dp, int index, int k, int cost){
        int num = days[index];
        while (index >= 0 && days[index] + k > num){
                index--;
        }
        return dp[index+1] + cost;
    }
}