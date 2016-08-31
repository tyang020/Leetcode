public class Solution {
    public int maximalSquare(char[][] matrix) {
        /** dp[i][j] defines the maximum size of a square that can be achieved at position (i, j)
         *  1. P[0][j] = matrix[0][j] (topmost row);
         *  2. P[i][0] = matrix[i][0] (leftmost column);
         *  3. For i > 0 and j > 0: if matrix[i][j] = 0, P[i][j] = 0; if matrix[i][j] = 1, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1.
         */
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length, maxSize = 0;
        int[][] dp = new int[m][n];
        // initialize dp[][]
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0]-'0';
            maxSize = Math.max(maxSize, dp[i][0]);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i]-'0';
            maxSize = Math.max(maxSize, dp[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]-'0' == 0) continue;
                dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize * maxSize;
    }
}