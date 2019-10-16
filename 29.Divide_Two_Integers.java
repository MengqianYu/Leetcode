class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend > 0 && divisor < 0){
            sign = -1;
        }else if (dividend < 0 && divisor > 0){
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long lans = sign * helper(ldividend, ldivisor);
        int ans = 0;
        if (lans > Integer.MAX_VALUE){
            ans = Integer.MAX_VALUE;
        }
        else if (lans < Integer.MIN_VALUE){
            ans = Integer.MIN_VALUE;
        }
        else{
            ans = (int)lans;
        }
        return ans;
    }
    
    private long helper(long dividend, long divisor){
        long sum = divisor;
        if (dividend < sum){
            return 0;
        }
        if (dividend < (sum+sum)) return 1;
        long ans = 1;
        //dividend -= sum;
        while (dividend >= (sum+sum)){
            sum+=sum;
            ans += ans;
            //System.out.println(sum);
        }
        //System.out.println(sum);
        return ans + helper(dividend-sum, divisor);
    }
}