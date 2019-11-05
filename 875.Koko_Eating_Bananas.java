class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1000000000;
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            int hrs = 0;
            for (int i : piles){
                hrs += ((i-1)/mid + 1);
            }
            if (hrs > H){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}