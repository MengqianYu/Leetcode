class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int head = 1;
        int num = 1;
        while (n > 1){
            if (left || n%2 == 1){
                head += num;
            }
            left = !left;
            n = n >> 1;
            num = num << 1;
        }
        return head;
    }
}