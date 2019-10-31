class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1;
        int hi = Integer.MAX_VALUE;
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            int num = getNumbersOfUglyNumbers((long)mid, (long)a, (long)b, (long)c);
            if (num < n){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return hi;
    }
    
    private int getNumbersOfUglyNumbers(long num, long a, long b, long c){
        long res = num/a + num/b + num/c - num/lcm(a, b) - num/lcm(a, c) - num/lcm(b, c) + num/lcm(lcm(a, b), c);
        return (int)res;
    }
    
    private long gcd(long a, long b){
        if (a == 0) return b;
        return gcd(b%a, a);
    }
    
    private long lcm(long a, long b){
        return (a*b/gcd(a, b));
    }
}