class Solution {
    public int maxTurbulenceSize(int[] A) {
        int res = 1;
        int inc = -1;
        int max = 1;
        int dec_l = 1;
        int inc_l = 1;
        for (int i = 1; i < A.length; i++){
            int temp = (A[i] - A[i-1]);
            if (temp == 0){
                inc_l = 1;
                dec_l = 1;
            }
            else if (temp * inc > 0){
                inc_l++;
                dec_l = 1;
                max = Math.max(inc_l, max);
            }
            else{
                dec_l++;
                inc_l = 1;
                max = Math.max(dec_l, max);
            }
            inc *= -1;
        }
        return max;
    }
}