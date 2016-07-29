public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
            
        int[] cols = new int[grid.length];
        cols[0] = grid[0][0];
        
        for (int i = 1; i < cols.length; i++) {
            cols[i] = grid[i][0] + cols[i-1];
        }
        
        for (int i = 1; i < grid[0].length; i++) {
            cols[0] += grid[0][i];
            for (int j = 1; j < cols.length; j++) {
                cols[j] = Math.min(cols[j], cols[j-1]) + grid[j][i];
            }
        }
        return cols[grid.length - 1];
    }
}