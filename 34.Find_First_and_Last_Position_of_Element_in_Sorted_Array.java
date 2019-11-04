class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums.length == 0) return res;
        int l = 0, r = nums.length-1;
        if (nums[l] > target || nums[r] < target) return res;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid] == target && (mid + 1 == nums.length||nums[mid+1] != target)){
                res[1] = mid;
                break;
            }
            if (nums[mid] > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        if (res[1] == -1) return res;
        l = 0;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (nums[mid] == target && (mid == 0 ||nums[mid-1] != target)){
                res[0] = mid;
                break;
            }
            if (nums[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return res;
    }
}