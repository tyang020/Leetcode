public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        /** In one iteration, we need to traverse right, down, left, up*/
        List<Integer> res = new ArrayList();
        int row_start = 0, row_end = matrix.length - 1;
        int col_start = 0, col_end = matrix.length - 1;
        while(col_start <= col_end && row_start <= row_end) {
            /* Traverse right */
            for (int i = col_start; i <= col_end; i++) {
                res.add(matrix[row_start][i]);
            }
            row_start++;
            
            /* Traverse down */
            for (int i = row_start; i <= row_end; i++) {
                res.add(matrix[i][col_end]);
            }
            col_end--;
            
            /* Traverse left */
            for (int i = col_end; i >= col_start; i--) {
                res.add(matrix[row_end][i]);
            }
            row_end--;
            
            /* Traverse up */
            for (int i = row_end; i >= row_start; i--) {
                res.add(matrix[col_start][i]);
            }
            col_start++;
        }
        return res;
    }
}