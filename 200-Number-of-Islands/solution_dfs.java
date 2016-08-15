public class Solution {
    public int numIslands(char[][] grid) {
        /** Visit all the elements which is equal to '1' and all of its neighbors until neighbors equal to '0'. Increment 1 to the island number.
         *  Once visited, all the visited element are marked as '0', so that we don't have to visit them again since they are already counted into an island.
         */
        if (grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void helper(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;
        grid[i][j] = '0';  // this node has been visited
        helper(grid, i-1, j, m, n);
        helper(grid, i+1, j, m, n);
        helper(grid, i, j-1, m, n);
        helper(grid, i, j+1, m, n);
    }
}