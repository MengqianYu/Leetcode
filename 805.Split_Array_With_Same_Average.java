class Solution {
    public boolean splitArraySameAverage(int[] A) {
        if (A.length < 2) return false;
        int sum = 0;
        Arrays.sort(A);
        for (int i : A) sum+= i;
        if (sum%A.length == 0){
            int target = sum/A.length;
            for (int a : A){
                if (a == target) return true;
            }
        }
        for (int i = 2; i <= A.length/2; i++){
            if ((sum*i) %A.length == 0){
                int target = sum*i/A.length;
                if (kSum(A, 0, target, i)) return true;
            }
        }
        return false;
    }
    
    private boolean kSum(int[] A, int start, int target, int k){
        if (start >= A.length) return false;
        if (k == 2){
            int l = start;
            int r = A.length-1;
            while (l < r){
                if (l != start && A[l-1] == A[l]){
                    l++;
                    continue;
                }
                if (r != A.length-1 && A[r+1] == A[r]){
                    r--;
                    continue;
                }
                int num = A[l]+A[r];
                if (num == target) return true;
                else if (num > target){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        else{
            for (int i = start; i < A.length; i++){
                if (i != start && A[i] == A[i-1]) continue;
                if (kSum(A, i+1, target-A[i], k-1)) return true;
            }
        }
        return false;
    }
}