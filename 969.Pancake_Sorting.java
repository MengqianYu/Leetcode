class Solution {
    List<Integer> res;
    public List<Integer> pancakeSort(int[] A) {
        int end = A.length;
        res = new ArrayList<>();
        while (end > 0){
            int max = A[0];
            int index = 0;
            for (int i = 1; i < end; i++){
                if (A[i] >= max){
                    max = A[i];
                    index = i;
                }
            }
            res.add(index+1);
            res.add(end);
            sort(A, index+1);
            sort(A, end);
            end--;
        }
        return res;
    }
    
    public void sort(int[] A, int len){
        int l = 0, r = len-1;
        while (l < r){
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }
}