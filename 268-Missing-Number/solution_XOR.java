public class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i]; 
            // By doing i ^ nums[i], each number appears twice except the missing number and n
        }
        return xor;
    }
}