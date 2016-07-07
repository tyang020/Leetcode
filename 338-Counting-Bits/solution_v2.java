public class Solution {
    public int[] countBits(int num) {
        /** The number of 1s in an integer n is the equal to 1 + res(cut off the most signigicant bit of n) */
        int p = 1, pow = 1;
        //pow : keeps track of the number of 2's power, while has only one 1.
        //p : keeps track of the difference between the current number and its corresponding power, i.e. 1100 p = 100
        for (int i = 1; i <= num; i++) {
            if (i == pow) {
                res[i] = 1;
                pow <<= 1;
                p = 1;
            } else {
                res[i] = res[p] + 1; //res(1100) = res(100) + 1
                p++;
            }
        }
    }
}