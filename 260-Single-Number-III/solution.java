public class Solution {
    public int[] singleNumber(int[] nums) {
        /**
         * Two passes:
         * 1. Get XOR result of all numbers: xor
         * 2. Find out an arbitrary '1' bit in xor(i.e. the least significant '1'). 
         *    If a digit in that bit is '1', it means the two number we want to get 
         *    in this bit is not the same. Then we can devide the numbers into 2 groups
         *    according to whether this bit is '0' or '1' and get the two numbers in each group.
         **/
         int[] res = new int[2];
         int xor = 0;
         for (int i = 0; i < nums.length; i++) {
             xor ^= nums[i];
         }
         xor &= -xor; // -xor = ~xor + 1 = ~(xor-1)
         
         for (int i = 0; i < nums.length; i++) {
             if ((nums[i] & xor) == 0)
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
         }
         return res;
    }
}