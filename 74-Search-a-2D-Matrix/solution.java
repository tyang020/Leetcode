public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Treat it as a 1d sorted array
        if (matrix == null || matrix.length == 0)
            return false;
            
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = matrix[mid / m][mid % m];
            
            if (num == target)
                return true;
            else if (num < target)
                low = mid + 1;
            else
                high = mid;
        }
        
        return false;
    }
}