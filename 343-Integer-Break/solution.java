public class Solution {
    public int integerBreak(int n) {
        int[] res = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (i < 7) {
                res[i] = (i / 2) * (i - i / 2);
            } else 
                res[i] = 3 * res[i - 3];
        }
        return res[n];
    }
}