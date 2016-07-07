public class Solution {
    public int[] countBits(int num) {
        /** The difference between i(1110) and i/2(111) is only whether the remaining bit is 0 or 1. res[i] = res[i/2] + i%2*/
        int[] res = new res[num+1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
        
    }
}