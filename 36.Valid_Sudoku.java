class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            int bitMask = 0;
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    int bit = bitMask & (1<<num);
                    bit >>= num;
                    if(bit == 1){
                        return false;
                    }
                    bitMask |= (1 << num);
                }
            }
        }
        for (int i = 0; i < 9; i++){
            int bitMask = 0;
            for (int j = 0; j < 9; j++){
                if (board[j][i] != '.'){
                    int num = board[j][i] - '0';
                    int bit = bitMask & (1<<num);
                    bit >>= num;
                    if(bit == 1){
                        return false;
                    }
                    bitMask |= (1 << num);
                }
            }
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int bitMask = 0;
                for (int k = 0; k < 3; k++){
                    for (int q = 0; q < 3; q++){
                        if (board[i*3+k][j*3+q] != '.'){
                            int num = board[i*3+k][j*3+q] - '0';
                            int bit = bitMask & (1<<num);
                            bit >>= num;
                            if(bit == 1){
                                return false;
                            }
                            bitMask |= (1 << num);
                        }
                    }
                }
            }
        }
        return true;
    }
}