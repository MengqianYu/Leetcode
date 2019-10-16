class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        //find min
        int length = nums.length;
        while (length > 1 && nums[length-1] == nums[0]){
            length--;
        }
        int lo = 0, hi = length-1;
        int mid = 0;
        while (lo < hi){
            mid = (lo+hi)/2;
            if (nums[mid] > nums[hi]){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        if (lo == 0) hi = length-1;
        else hi = lo-1;
        while (nums[lo] <= target && nums[hi] >= target){
            if (lo > hi){
                mid = ((length - lo + hi)/2 + lo)%length;
            }
            else{
                mid = lo + (hi-lo)/2;
            }
            if (mid == length) mid = 0;
            if (nums[mid] == target) return true;
            if (nums[mid] > target){
                if (mid > 0){
                    hi = mid-1;
                }
                else{
                    hi = length-1;
                }
            }
            else{
                if (mid+1 < length){
                    lo = mid+1;
                }
                else{
                    lo = 0;
                }
            }
        }
        return false;
    }
}