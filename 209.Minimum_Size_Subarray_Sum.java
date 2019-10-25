class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length;
        boolean found = false;
        int l = 0, r = 0;
        int curr = 0;
        while (l < nums.length && r < nums.length){
            curr += nums[r];
            while (curr >= s && l <= r){
                found = true;
                res = Math.min(r-l+1, res);
                curr -= nums[l];
                l++;
            }
            r++;
        }
        return found? res : 0;
    }
}