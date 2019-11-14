class Solution {
    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        if (height.length == 0) return 0;
        lmax[0] = 0;
        rmax[height.length-1] = 0;
        int res = 0;
        for (int i = 1; i < height.length; i++){
            lmax[i] = Math.max(lmax[i-1], height[i-1]);
        }
        for (int i = height.length-2; i >= 0; i--){
            rmax[i] = Math.max(rmax[i+1], height[i+1]);
        }
        for (int i = 0; i < height.length; i++){
            int h = Math.min(lmax[i], rmax[i]);
            if (h > height[i]){
                res += (h-height[i]);
            }
        }
        return res;
    }
}