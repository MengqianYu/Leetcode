class Solution {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        if (N == 0) return "0";
        while (N != 0){
            int r = N % (-2);
            N /= (-2);
            if (r < 0){
                N++;
                r = 1;
            }
            sb.append(r);
        }
        return sb.reverse().toString();
    }
}