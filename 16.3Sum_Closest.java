class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++){
            int l = 0, r = i-1;
            int localmin = Integer.MAX_VALUE;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < min){
                    res = sum;
                    min = Math.abs(sum-target);
                }
                if (sum == target){
                    return target;
                }
                else if (sum > target){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return res;
    }
}