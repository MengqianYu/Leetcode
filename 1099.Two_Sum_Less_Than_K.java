class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0, r = A.length-1;
        int res = -1;
        while (l < r){
            int sum = A[l]+A[r];
            if (sum < K){
                res = Math.max(sum, res);
                l++;
            }
            else if (sum >= K){
                r--;
            }
        }
        return res;
    }
}