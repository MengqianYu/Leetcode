class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int index, int target){
        if (index >= candidates.length) return;
        if (target < 0) return;
        if (target == 0){
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        for (int i = index; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs(res, list, candidates, i, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}