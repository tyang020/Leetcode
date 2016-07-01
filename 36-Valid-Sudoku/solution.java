public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row check
        for(int i = 0; i < 9; i++) {
            boolean[] map = new boolean[9]; // initialize with false
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (map[(int)board[i][j] - '1']) 
                    return false;
                map[(int)board[i][j] - '1'] = true;
            }
        }
        //column check
        for (int j = 0; j < 9; j++) {
            boolean[] map = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                if (map[(int)board[i][j]-'1'])
                    return false;
                map[(int)board[i][j]-'1'] = true;
            }
        }
        //check each subbox
        for (int block = 0; block < 9; block++) {
            boolean[] map = new boolean[9];
            for (int i = block/3*3; i < block/3*3 + 3; i++) {
                for (int j = block%3*3; j < block%3*3+3; j++) {
                    if (board[i][j] == '.') continue;
                    if (map[(int)board[i][j]-'1'])
                        return false;
                    map[(int)board[i][j]-'1'] = true; 
                }
            }
        }
        return true;
    }
}