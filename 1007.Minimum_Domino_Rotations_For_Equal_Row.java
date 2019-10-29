class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n1 = helper(A, B);
        int n2 = helper(B, A);
        if (n1 == -1) return n2;
        if (n2 == -1) return n1;
        return Math.min(n1, n2);
    }
    
    public int helper(int[] A, int[] B){
        int length = A.length;
        int index = -1;
        for (int i = 0; i < length; i++){
            if (A[i] != B[i]){
                index = i;
                break;
            }
        }
        if (index == -1) return 0;
        int top1 = A[index];
        int n1 = 0;
        boolean b1 = true;
        for (int i = 0; i < length; i++){
            if (A[i] != top1 && B[i] == top1){
                n1++;
            }
            else if (A[i] != top1 && B[i]!=top1){
                b1 = false;
            }
        }
        int top2 = B[index];
        int n2 = 0;
        boolean b2 = true;
        for (int i = 0; i < length; i++){
            if (A[i] != top2 && B[i] == top2){
                n2++;
            }
            else if (A[i] != top2 && B[i]!=top2){
                b2 = false;
            }
        }
        if (b1 && b2){
            return Math.min(n1, n2);
        }
        if (b1) return n1;
        if (b2) return n2;
        return -1;
    }
}