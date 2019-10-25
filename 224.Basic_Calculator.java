class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int num = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                num = num*10 + ch -'0';
            }
            else if (ch == '+'){
                res += num*sign;
                num = 0;
                sign = 1;
            }
            else if (ch == '-'){
                res += num*sign;
                num = 0;
                sign = -1;
            }
            else if (ch == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }
            else if (ch == ')'){
                res += num * sign;
                num = 0;
                sign = 0;
                int popsign = stack.pop();
                int pop = stack.pop();
                pop += popsign * res;
                res = pop;
            }
        }
        res += num * sign;
        return res;
    }
}