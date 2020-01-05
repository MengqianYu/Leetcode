class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder();
        while (num>0){
            int digit = num%10;
            sb.append(digit);
            num /= 10;
        }
        sb.reverse();
        char[] chrs = sb.toString().toCharArray();
        int[] max = new int[chrs.length];
        max[max.length-1] = max.length-1;
        for (int i = max.length-2; i >= 0; i--){
            if (chrs[i] > chrs[max[i+1]]){
                max[i] = i;
            }
            else{
                max[i] = max[i+1];
            }
        }
        for (int i = 0; i < max.length; i++){
            if (chrs[max[i]] != chrs[i]){
                char temp = chrs[i];
                chrs[i] = chrs[max[i]];
                chrs[max[i]] = temp;
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < chrs.length; i++){
            res = res*10 + chrs[i] - '0';
        }
        return res;
    }
}