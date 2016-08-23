public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return word.isEmpty();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length())
            return true;
        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1)
            return false;
        
        if (board[i][j] != word.charAt(idx))
            return false;
        board[i][j] = '*'; // To mark this letter at current position as visited.
        if (helper(board, i-1, j, word, idx+1))
            return true;
        if (helper(board, i+1, j, word, idx+1))
            return true;
        if (helper(board, i, j-1, word, idx+1))
            return true;
        if (helper(board, i, j+1, word, idx+1))
            return true;
        board[i][j] = word.charAt(idx);
        return false;
    }
}