class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'X' && (i == 0 || board[i-1][j] != 'X') && (j == 0 || board[i][j-1] != 'X')){
                    res++;
                }
            }
        }
        return res;
    }
}