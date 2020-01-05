class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] dp = new int[arr.length+1];
        for (int i = 1; i < dp.length; i++){
            dp[i] = dp[i-1] ^ arr[i-1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i< queries.length; i++){
            res[i] = dp[queries[i][0]] ^ dp[queries[i][1]+1];
        }
        return res;
    }
}