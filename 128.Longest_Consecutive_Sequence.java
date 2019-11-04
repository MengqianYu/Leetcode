class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (start.containsKey(nums[i])||end.containsKey(nums[i])) continue;
            int lo = end.getOrDefault(nums[i]-1, 0);
            int hi = start.getOrDefault(nums[i]+1, 0);
            int n = hi+lo+1;
            start.put(nums[i]-lo, n);
            end.put(nums[i]+hi, n);
            start.put(nums[i], 1+hi);
            end.put(nums[i], 1+lo);
            max = Math.max(n, max);
        }
        return max;
    }
}