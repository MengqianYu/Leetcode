class Solution {
    public boolean find132pattern(int[] nums) {
        //step I: find the minimum number on the left for each index
        //step II: check if there exists a number on the right that is smaller than the current number but greater than the min on the left
        //keep a decreasing stack
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        if (len == 0) return false;
        int[] min = new int[len];
        min[0] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++){
            min[i] = Math.min(min[i-1], nums[i-1]);
        }
        for (int i = len-1; i >= 0; i--){
            if (stack.isEmpty()){
                stack.push(nums[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() <= min[i]){
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < nums[i]){
                return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }
}