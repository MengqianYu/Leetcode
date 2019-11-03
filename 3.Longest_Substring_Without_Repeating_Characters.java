class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] chrs = new int[256];
        int l = 0, r = 0;
        while (l <= r && r <s.length()){
            char ch = s.charAt(r);
            chrs[ch]++;
            while (chrs[ch] > 1){
                chrs[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}