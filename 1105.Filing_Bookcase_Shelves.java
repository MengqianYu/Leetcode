class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= books.length; i++){
            int width = 0;
            int height = 0;
            for (int j = i-1; j >= 0; j--){
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                if (width > shelf_width) break;
                dp[i] = Math.min(dp[i], height + dp[j]);
            }
        }
        return dp[books.length];
    }
}