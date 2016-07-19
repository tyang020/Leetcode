public class Solution {
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        if (n == 0) return 1;
        for (int i = 1; i < n+1; i++) {
            int j;
            for (j = 0; j < i / 2; j++) {
                f[i] += 2 * f[i - 1 - j] * f[j];
            }
            if (i % 2 != 0) {
                f[i] += f[j] * f[j];
            }
        }
        return f[n];
    }
}