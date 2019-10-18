class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        if (m == 0) return board;
        int n = board[0].length;
        boolean found = true;
        while (found){
            found = false;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    int candy = Math.abs(board[i][j]);
                    if (candy == 0) continue;
                    if (i + 2 < m && Math.abs(board[i+1][j]) == candy && Math.abs(board[i+2][j]) == candy){
                        board[i][j] = -candy;
                        board[i+1][j] = -candy;
                        board[i+2][j] = -candy;
                        found = true;
                    }
                    if (j + 2 < n && Math.abs(board[i][j+1]) == candy && Math.abs(board[i][j+2]) == candy){
                        board[i][j] = -candy;
                        board[i][j+1] = -candy;
                        board[i][j+2] = -candy;
                        found = true;
                    }
                }
            }
            if (found){
                for (int j = 0; j < n; j++){
                    int num = 0;
                    for (int i = m-1; i >= 0 ; i--){
                        if (board[i][j] < 0){
                            num++;
                        }
                        else{
                            board[i+num][j] = board[i][j];
                        }
                    }
                    for (int k = 0; k < num; k++){
                        board[k][j] = 0;
                    }
                }
            }
        }
        return board;
    }
}