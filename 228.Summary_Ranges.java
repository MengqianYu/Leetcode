class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int l = 0, r = 0;
        while (r <= nums.length){
            if (r == nums.length || nums[r] > nums[l] + r-l){
                StringBuilder sb = new StringBuilder();
                sb.append(nums[l]);
                if (l != r-1){
                    sb.append("->").append(nums[r-1]);
                }
                res.add(sb.toString());
                l = r;
            }
            r++;
        }
        
        return res;
    }
}