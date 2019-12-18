class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int start = 0;
        int end = 0;
        while (start < s.length){
            if (end == s.length || s[end] == ' '){
                reverse(s, start, end-1);
                start = end+1;
            }
            end++;
        }
    }
    
    private void reverse(char[] s, int start, int end){
        while (start < end){
            char ch = s[start];
            s[start] = s[end];
            s[end] = ch;
            start++;
            end--;
        }
    }
}