public class Solution {
    public boolean isPerfectSquare(int num) {
        //a square number is the sum of 1, 3, 5, 7...
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}