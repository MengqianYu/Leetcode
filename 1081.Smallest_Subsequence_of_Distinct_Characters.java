class Solution {
    public String smallestSubsequence(String text) {
        char[] chrs = new char[256];
        for (char ch : text.toCharArray()){
            chrs[ch]++;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for (char ch : text.toCharArray()){
            chrs[ch]--;
            if (set.contains(ch)) continue;
            while (!stack.isEmpty() && stack.peek() > ch && chrs[stack.peek()] > 0){
                set.remove(stack.pop());
            }
            stack.push(ch);
            set.add(ch);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}