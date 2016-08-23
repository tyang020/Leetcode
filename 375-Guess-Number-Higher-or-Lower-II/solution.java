public class Solution {
    public int getMoneyAmount(int n) {
        /** For each number x in range[i~j]
         *  we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
         *  --> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
         *  then we get DP([i~j]) = min{xi, ... ,xj}
         *  --> // this min makes sure that you are minimizing your cost.
         */
         int[][] table = new int[n+1][n+1];
         for (int j = 2; j <= n; j++) {
             table[j-1][j] = j - 1;
             for (int i = j-2; i > 0; i--) {
                 int global_min = Integer.MAX_VALUE;
                 for (int k = i+1; k < j; k++) {
                     int local_max = k + Math.max(table[i][k-1], table[k+1][j]);
                     global_min = Math.min(local_max, global_min);
                 }
                 table[i][j] = global_min;
             }
         }
         return table[1][n];
    }
}