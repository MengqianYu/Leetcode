class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        int m = 0;
        while (true){
            m++;
            int x = 2*N - m*(m+1);
            if (x < 0){
                break;
            }
            if (x%(2*m)==0){
                count++;
            }
        }
        return count;
    }
}