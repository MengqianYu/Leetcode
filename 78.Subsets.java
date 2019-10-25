class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++){
            int size = res.size();
            for (int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<>();
                list.addAll(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}