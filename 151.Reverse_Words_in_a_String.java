class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll("( )+", " ");
        char[] chrs = s.toCharArray();
        int start = 0;
        for (int i = 0; i <= chrs.length; i++){
            if (start == -1 && chrs[i] != ' '){
                start = i;
            }
            else if (start != -1 && (i == chrs.length || chrs[i] == ' ')){
                reverse(start, i-1, chrs);
                start = -1;
            }
        }
        reverse(0, chrs.length-1, chrs);
        return String.valueOf(chrs);
    }
    
    private void reverse(int start, int end, char[] chrs){
        while (start < end){
            char ch = chrs[start];
            chrs[start] = chrs[end];
            chrs[end] = ch;
            start++;
            end--;
        }
    }
}