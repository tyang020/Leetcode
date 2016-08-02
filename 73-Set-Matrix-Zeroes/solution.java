public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col_0 = false;
        int m = matrix.length, n = m==0 ? 0 : matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            //check if first col has 0, if it dose, set col_0 to true
            //j = 0
            if (matrix[i][0] == 0) 
                col_0 = true;
            
            // j = 1 ~ (n-1)
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // Use the first row and col to save whether this row or col has 0; if it dose, set it to 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // To avoid change the information about each row and col in the first row and col, 
        // we need to update 0 in a bottom-up way
            
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >=1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            
            //j = 0
            if (col_0)
                matrix[i][0] = 0;
        } 
    }
}