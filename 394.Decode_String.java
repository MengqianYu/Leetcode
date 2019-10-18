class Solution {
    public String decodeString(String s) {
        Stack<String> stack_str = new Stack<>();
        Stack<Integer> stack_int = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            else if (ch == '['){
                stack_int.push(num);
                num = 0;
                stack_str.push(sb.toString());
                sb = new StringBuilder();
            }
            else if (ch == ']'){
                String ss = sb.toString();
                sb = new StringBuilder();
                int k = stack_int.pop();
                for (int j = 0; j < k; j++){
                    sb.append(ss);
                }
                String prev = stack_str.pop();
                ss = sb.toString();
                sb = new StringBuilder();
                sb.append(prev);
                sb.append(ss);
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}