public class Solution {
    public int rob(int[] nums) {
        // Calculate the max rob from house 0 to nums.length-2 and house 1 to house nums.length-1;
        // Choose the max of above result
        if(nums.length == 1)
            return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    public int robHelper(int[] nums, int start, int end) {
        int preMax = 0, max = 0;
        for (int i = start; i <=end; i++) {
            int pre = preMax;
            preMax = max;
            max = Math.max(pre+nums[i], max);
        }
        return max;
    }
}