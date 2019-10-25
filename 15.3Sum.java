class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 2; i < nums.length; i++){
            if (i+1 < nums.length && nums[i] == nums[i+1]) continue;
            int target = -nums[i];
            int l = 0, r = i-1;
            while (l < r){
                if (nums[l] + nums[r] < target){
                    l++;
                }
                else if (nums[l] + nums[r] > target){
                    r--;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(nums[i]);
                    res.add(list);
                    int lnum = nums[l];
                    int rnum = nums[r];
                    while (l <= r && nums[l] == lnum){
                        l++;
                    }
                    while (r >= l && nums[r] == rnum){
                        r--;
                    }
                }
            }
        }
        return res;
    }
}