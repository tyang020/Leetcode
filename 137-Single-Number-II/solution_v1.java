public class Solution {
    public int singleNumber(int[] nums) {
        /** All '1's in every bit must appear 3 times without counting the single one number.
            Count how many times '1' appears in each bit and then mod 3, the result would be the single number
        */
        //O(n) with extra memory
        int [] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                int rotate;
                rotate = nums[i] >> j;
                if (rotate != 0) {
                    bit[j] += rotate & 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (bit[i] % 3 << i);
        }
        return res;
    }
}