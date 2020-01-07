class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(candidates, new ArrayList<>(), 0, target);
        return res;
    }
    
    private void dfs(int[] candidates, List<Integer> list, int pos, int target){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;
        for (int i = pos; i < candidates.length; i++){
            if (i != pos && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(candidates, list, i+1, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}