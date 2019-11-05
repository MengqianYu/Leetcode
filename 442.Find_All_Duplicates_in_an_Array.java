class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i+1){
                int n = nums[i];
                if (n == 0) break;
                if (nums[n-1] == n){
                    nums[i] = 0;
                    res.add(n);
                }
                else{
                    int temp = nums[n-1];
                    nums[n-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return res;
    }
}