public class Solution {
    public void rotate(int[] nums, int k) {
        /** Solution1: O(n) time and O(n) space */
        int[] res = new int[nums.length];
        for (int i = 0; i < k; i++) {
            res[i] = nums[nums.length - k + i];
        }
        for (int i = k; i < nums.length; i++) {
            res[i] = nums[i - k];
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }
}