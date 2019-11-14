class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int cnt = 0;
        int[] chrs = new int[256];
        int l = 0, r = 0;
        int max = 0;
        while (l <= r && r < s.length()){
            char ch = s.charAt(r);
            if (chrs[ch] == 0){
                cnt++;
            }
            chrs[ch]++;
            while (cnt > k){
                int charleft = s.charAt(l);
                chrs[charleft]--;
                if (chrs[charleft] == 0){
                    cnt--;
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}