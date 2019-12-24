class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        if (nums.length == 0) return false;
        int cnt = nums.length/k;
        Arrays.sort(nums);
        int pointer = 0;
        int newfirst = 0;
        for (int i = 0; i < cnt; i++){
            int first = nums[newfirst];
            nums[newfirst] = -1;
            int prev = first;
            newfirst = -1;
            for (int j = 0; j < nums.length; j++){
                if (prev - first == k-1) break;
                if (nums[j] == -1) continue;
                if (nums[j] == prev+1){
                    prev = prev+1;
                    nums[j] = -1;
                }
                else if (newfirst == -1){
                    newfirst = j;
                }
            }
            if (newfirst == -1){
                newfirst = (i+1)*k;
            }
            if (prev - first != k-1) return false;
        }
        return true;
    }
}