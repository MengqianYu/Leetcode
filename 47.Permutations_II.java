class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i : nums) list.add(i);
        return helper(list);
    }
    
    private List<List<Integer>> helper(List<Integer> list){
        List<List<Integer>> res = new ArrayList<>();
        if (list.size() == 1){
            res.add(list);
            return res;
        }
        for (int i = 0; i < list.size(); i++){
            if (i > 0 && list.get(i) == list.get(i-1)) continue;
            List<Integer> next = new ArrayList<>();
            for (int j = 0; j < list.size(); j++){
                if (i != j){
                    next.add(list.get(j));
                }
            }
            List<List<Integer>> permutations = helper(next);
            for (int j = 0; j < permutations.size(); j++){
                permutations.get(j).add(list.get(i));
                res.add(permutations.get(j));
            }
        }
        return res;
    }
}