class Solution {
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) return 11;
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString();
            int y = Integer.parseInt(s + r.substring(1));
            if (y >= N && isPrime(y)) return y;
        }
        return -1;
    }

    
    private boolean isPrime(int n){
        if (n == 2) return true;
        if (n == 1 || n == 0 || n%2 == 0) return false;
        for (int i = 3; i*i <= n; i+=2){
            if (n%i == 0) return false;
        }
        return true;
    }
}