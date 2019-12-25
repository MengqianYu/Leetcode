class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) continue;
            int slow = nextIndex(nums, i);
            int fast = nextIndex(nums, slow);
            while (nums[fast] * nums[i] > 0){
                if (slow == fast){
                    if (nextIndex(nums, slow) == slow){
                        break;
                    }
                    System.out.println(slow);
                    return true;
                }
                slow = nextIndex(nums, slow);
                fast = nextIndex(nums, fast);
                if (nums[i] * nums[fast] < 0) break;
                fast = nextIndex(nums, fast);
            }
            slow = i;
            while (nums[slow] * nums[i] > 0){
                nums[slow] = 0;
                slow = nextIndex(nums, slow);
            }
        }
        return false;
    }
    
    private int nextIndex(int[] nums, int index){
        return (index + nums[index]%nums.length + nums.length)%nums.length;
    }
}