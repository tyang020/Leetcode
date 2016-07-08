public class Solution {
    public int maxSubArray(int[] nums) {
        int max_local = nums[0], max_global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_local = Math.max(nums[i], max_local+nums[i]);
            if (max_local > max_global)
                max_global = max_local;
        }
        return max_global;
    }
}