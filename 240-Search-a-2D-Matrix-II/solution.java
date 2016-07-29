public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //time complexity O(m+n)
        if (matrix.length == 0 || matrix == null)
            return false;
        int row = 0, col = matrix[0].length - 1;
        
        while (col >= 0 && row < matrix.length) {
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                row++;
            else
                col--;
        }
        
        return false;
    }
}