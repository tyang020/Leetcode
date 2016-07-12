public class Solution {
    public int integerBreak(int n) {
        //O(n) time and O(n) space
        /*
        int[] res = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (i < 7) {
                res[i] = (i / 2) * (i - i / 2);
            } else 
                res[i] = 3 * res[i - 3];
        }
        return res[n];
        */
        
        //O(n) time and O(1) space
        if (n == 2) return 1;
        if (n == 3) return 2;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return n * res;
    }
}