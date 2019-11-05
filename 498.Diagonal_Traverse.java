class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[]{};
        int n = matrix[0].length;
        int cnt = 0;
        int[] res = new int[m*n];
        boolean up = true;
        int i = 0, j = 0;
        while (cnt < m*n){
            res[cnt] = matrix[i][j];
            cnt++;
            if (up){
                if (j + 1 >= n){
                    i++;
                    up = false;
                }
                else if (i == 0){
                    up = false;
                    j++;
                }
               else{
                   i--;
                   j++;
               } 
            }
            else{
                if (i == m-1){
                    up = true;
                    j++;
                }
                else if (j == 0){
                    up = true;
                    i++;
                }
                else{
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}