public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] f = new int[n+1];
        f[1] = 10;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * 10 - 9 * (i - 1);
        }
        return f[n];
    }
}