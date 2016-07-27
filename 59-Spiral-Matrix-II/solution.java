public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;
        int row_start = 0, row_end = n - 1;
        int col_start = 0, col_end = n - 1;
        int num = 1;
        while (row_start <= row_end) {
            // Traverse Right
            for (int i = col_start; i <= col_end; i++) {
                res[row_start][i] = num++;
            }
            row_start++;
            
            // Traverse Down
            for (int i = row_start; i <= row_end; i++) {
                res[i][col_end] = num++;
            }
            col_end--;
            
            // Traverse Left
            for (int i = col_end; i >= col_start; i--) {
                res[row_end][i] = num++;
            }
            row_end--;
            
            // Traverse Up
            for (int i = row_end; i >= row_start; i--) {
                res[i][col_start] = num++;
            }
            col_start++;
        }
        return res;
    }
}