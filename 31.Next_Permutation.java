class Solution {
    public void nextPermutation(int[] nums) {
        int start = 0;
        for (int i = nums.length-1; i>0; i--){
            if (nums[i] > nums[i-1]){
                start = i;
                int temp = nums.length-1;
                for (int j = start; j < nums.length; j++){
                    if (nums[j] <= nums[i-1]){
                        temp = j-1;
                        break;
                    }
                }
                swap(nums, i-1, temp);
                break;
            }
        }
        reverse(nums, start, nums.length-1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}