class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 1;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[len-1] < nums[i]){
                dp[len] = nums[i];
                len++;
            }
            else{
                int index = binarySearch(dp, 0, len-1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] A, int start, int end, int target){
        if (start > end) return-1;
        int mid = start + (end-start)/2;
        if (A[mid] == target){
            return mid;
        }
        else if ((mid == 0||A[mid-1] < target) && A[mid] > target){
            return mid;
        }
        else if (A[mid] < target){
            return binarySearch(A, mid+1, end, target);
        }
        else{
            return binarySearch(A, start, end-1, target);
        }
    }
}