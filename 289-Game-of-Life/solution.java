public class Solution {
    public void gameOfLife(int[][] board) {
        /**
         * [2nd bit, 1st bit] = [next state, current state];
         * 
         * Initial states : 00, 01
         * 
         * State change:
         * 1. 00 -> 10 : lives == 3 && current == 0
         * 2. 01 -> 11 : lives >= 2 && lives <= 3 && current == 1;
         * 
         * Get current state: board[row][col] & 1;
         * Get next state: board[row][col] >> 1
         */
         
        int m = board.length, n = (m==0 ? 0 : board[0].length);
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int lives = -board[row][col];
                
                // Count the number of lives;
                for (int i = Math.max(row-1, 0); i < Math.min(row+2, m); i++) {
                    for (int j = Math.max(col-1, 0); j < Math.min(col+2, n); j++) {
                        lives += (board[i][j] & 1);
                    }
                }
                
                //Check if next state is live
                if ((lives | board[row][col]) == 3)
                    board[row][col] |= 2;
            /*    if (board[row][col] == 0 && lives == 3)
                    board[row][col] = 2;
                if (board[row][col] ==1 && lives >= 2 && lives <= 3)
                    board[row][col] = 3;
            */
            }
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] >>= 1;
            }
        }
    }
}