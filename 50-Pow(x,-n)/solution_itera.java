public class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE && Math.abs(x) != 1.0)
            return 0;
        
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1.0;
        while (n > 0) {
            // if n is odd number
            if ((n & 1) != 0)
                res *= x;
            x *= x;
            n = n / 2;
        }
        return res;
    }
}