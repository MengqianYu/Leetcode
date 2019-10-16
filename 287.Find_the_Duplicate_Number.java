class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 0, hi = nums.length;
        while (lo < hi){
            int mid = (lo+hi)/2;
            int cnt = 0;
            for (int i : nums){
                if (i <= mid){
                    cnt++;
                }
            }
            if (cnt > mid){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
}