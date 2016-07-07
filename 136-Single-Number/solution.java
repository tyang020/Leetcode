public class Solution {
    public int singleNumber(int[] nums) {
        
        /** XOR(Exclusive OR) is commutative and associative. And 0 ^ x = x; x^x=0 */
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        
        return res;
    }
}