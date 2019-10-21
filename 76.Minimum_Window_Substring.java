class Solution {
    public String minWindow(String s, String t) {
        int[] chrs = new int[256];
        for (char ch : t.toCharArray()){
            chrs[ch]++;
        }
        int min = Integer.MAX_VALUE;
        int minL = 0;
        int minR = -1;
        int l = 0, r = 0;
        int count = 0;
        while (l < s.length() && r < s.length()){
            char ch = s.charAt(r);
            if (chrs[ch] > 0){
                count++;
            }
            chrs[ch]--;
            if (count == t.length()){
                while (count == t.length()){
                    char lch = s.charAt(l);
                    if (min > r-l+1){
                        min = r-l+1;
                        minL = l;
                        minR = r;
                    }
                    if (chrs[lch]++ >= 0){
                        count--;
                    }
                    l++;
                }
            }
            r++;
        }
        return s.substring(minL, minR+1);
    }
}