class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res = kSum(nums, target, 4, 0);
        return res;
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int k, int index){
        List<List<Integer>> res = new ArrayList<>();
        if (index >= nums.length){
            return res;
        }
        if (k == 2){
            int lo = index, hi = nums.length - 1;
            while (lo < hi){
                int sum = nums[lo] + nums[hi];
                if (sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    //System.out.println("target: " + target + " curr: " + nums[index] + " lo: " + nums[lo] + " hi: " + nums[hi]);
                    res.add(list);
                    int loval = nums[lo];
                    int hival = nums[hi];
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == loval){
                        lo++;
                    }
                    while (lo < hi && nums[hi] == hival){
                        hi--;
                    }
                }
                else if (sum > target){
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }
        else{
            for (int i = index; i < nums.length; i++){
                if (i == index || nums[i]!=nums[i-1]){
                    List<List<Integer>> temp = kSum(nums, target-nums[i], k-1, i+1);
                    for (List<Integer> list : temp){
                        list.add(nums[i]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
}