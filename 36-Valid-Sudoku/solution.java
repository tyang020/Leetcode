public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < char.length; i++) {
            for(int j = 0; j < char[i].length; j++) {
                if ()
            }
        }
    }
    public boolean isValid(char[][] board, int row, int col) {
        for (int i = row + 1; i < 9; i++){
            if (char[row][i] == '.') continue;
            if (char[row][col] == char[i][col])
                return false;
        }
        for (int i = col + 1; i < 9; i++) {
            if (char[row][i] == '.') continue;
            if (char[row][col] == char[row][i]){
                return false;
            }
        }
        for (int i = row, j; i < (row/3+1)*3; i++) {
            for ()
        }
    }
}