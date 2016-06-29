public class Solution {
    public int reverse(int x) {
        // Long is to check overflow
        long res = 0;
        //int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE)
            return (int)res;
        else
            return 0;
    }
}