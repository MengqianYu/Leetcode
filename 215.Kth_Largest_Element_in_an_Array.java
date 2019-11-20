class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        while (l < r){
            int mid = partition(nums, l, r);
            if (mid == k-1){
                return nums[k-1];
            }
            else if (mid > k-1){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return nums[k-1];
    }
    
    private int partition(int[] nums, int lo, int hi){
        int l = lo;
        int r = hi;
        Random rand = new Random();
        int index = rand.nextInt(hi-lo+1)+lo;
        int pivot = nums[index];
        nums[index] = nums[l];
        nums[l] = pivot;
        while (l < r){
            while (l < r && nums[r] <= pivot){
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] >= pivot){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}