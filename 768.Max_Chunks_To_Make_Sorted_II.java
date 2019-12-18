class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] premax = new int[arr.length];
        int[] postmin = new int[arr.length];
        premax[0] = arr[0];
        postmin[arr.length-1] = arr[arr.length-1];
        for (int i = 1; i < arr.length; i++){
            premax[i] = Math.max(premax[i-1], arr[i]);
        }
        for (int i = arr.length-2; i >= 0; i--){
            postmin[i] = Math.min(postmin[i+1], arr[i]);
        }
        int cnt = 1;
        for (int i = 0; i < arr.length-1; i++){
            if (premax[i] <= postmin[i+1]){
                cnt++;
            }
        }
        return cnt;
    }
}