class Solution {
    int[] presum;
    int sum;
    Random random;

    public Solution(int[] w) {
        presum = new int[w.length];
        for (int i = 0; i < w.length; i++){
            sum += w[i];
            presum[i] = sum;
        }
        random = new Random();
    }
    
    public int pickIndex() {
        int target = random.nextInt(sum);
        int l = 0, r = presum.length-1;
        while (l < r){
            int mid = l + (r-l)/2;
            if (presum[mid] <= target){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */