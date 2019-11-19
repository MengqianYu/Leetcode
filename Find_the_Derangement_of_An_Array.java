class Solution {
    public int findDerangement(int n) {
        int mod = 1000000007;
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        int slow = 0;
        int fast = 1;
        for (int i = 3; i <= n; i++){
            long l = (long)((i-1)%mod) * (fast%mod + slow%mod);
            slow = fast;
            fast = (int)(l%mod);
        }
        return fast;
    }
}