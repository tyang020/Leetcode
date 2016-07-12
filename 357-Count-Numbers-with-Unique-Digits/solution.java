public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        /* can not work when f is the results of n, would be complicate;
        if (n == 0) return 1;
        int[] f = new int[n+1];
        int a = 1;
        f[1] = 10;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * 10 - 9 * (i - 1) * a - 9;
            if (i == 2) f[i] += 9;
            a *= 10 - i + 1; 
        }
        return f[n];
        */
        
        /** Let f be the number of numbers with unique digits of length n 
         *  f(1) = 10(0~9);
         *  f(2) = 9*9;
         *  f(3) = 9*9*8;
         *  Then the results of this problem would be f(1)+f(2)+...+f(n);
         */
         if (n == 0) return 1;
         int res = 10, curRes = 9;
         int i = 2;
         for (int i = 2; i < n && i <= 10; i++) {
             curRes *= 10 - i + 1;
             res += curRes;
         }
         return res;
    }
}