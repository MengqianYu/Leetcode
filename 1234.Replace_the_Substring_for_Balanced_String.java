class Solution {
    public int balancedString(String s) {
        int target = s.length()/4;
        int[] chrs = new int[256];
        chrs['Q'] = -target;
        chrs['W'] = -target;
        chrs['E'] = -target;
        chrs['R'] = -target;
        int count = 0;
        for (char ch : s.toCharArray()){
            chrs[ch]++;
            if (chrs[ch] > 0){
                count++;
            }
        }
        if (count == 0) return 0;
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (l < s.length() && r < s.length()){
            if (chrs[s.charAt(r)]-- > 0){
                count--;
            }
            while (count == 0){
                min = Math.min(min, r-l+1);
                if (chrs[s.charAt(l)]++ >= 0){
                    count++;
                }
                l++;
            }
            r++;
        }
        return min;
    }
}