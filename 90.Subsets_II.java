class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        int start = 0;
        int end = 0;
        while (start < nums.length){
            while (end < nums.length && nums[end] == nums[start]){
                end++;
            }
            int size = res.size();
            for (int i = 0; i < size; i++){
                for (int j = 0; j < end-start; j++){
                    List list = new ArrayList<>();
                    list.addAll(res.get(i));
                    for (int k = 0; k <= j; k++){
                        list.add(nums[start]);
                    }
                    res.add(list);
                }
            }
            start = end;
        }
        return res;
    }
}