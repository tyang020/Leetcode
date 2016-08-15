public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int m = board.length, n = board[0].length;
        // set all boarder 'O's to 'V's
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                border(board, i, 0, m, n);
            if (board[i][n-1] == 'O')
                border(board, i, n-1, m, n);
        }
        for (int i = 1; i < n-1; i++) {
            if (board[0][i] == 'O')
                border(board, 0, i, m, n);
            if (board[m-1][i] == 'O')
                border(board, m-1, i, m, n);
        }
        
        // set all inner 'O's to 'X's
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        
        // reset 'V's to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void border(char[][] board, int i, int j, int m, int n) {
        if (board[i][j] != 'O')
            return;
        board[i][j] = 'V';
        // When neighbors are not on the border
        if (i-1 > 0)
            border(board, i-1, j, m, n);
        if (i+1 < m-1)
            border(board, i+1, j, m, n);
        if (j-1 > 0)
            border(board, i, j-1, m, n);
        if (j+1 < n-1)
            border(board, i, j+1, m, n);
    }
}