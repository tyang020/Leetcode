public class Solution {
    public int superPow(int a, int[] b) {
        int base = 1337;
        int aa = a % 1337;
        int res = 1;
        for (int i = 0; i < b.length; i++) {
            int c = res % base;
            res = 1;
            for (int j = 0; j < 10; j++) {
                res = (res * c) % base;
            }
            for (int j = 0; j < b[i]; j++)
                res = (res * aa) % base;
        }
        return res;
    }
}