public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int diff = nums[1] - nums[0];
        int count = 1 + (diff == 0 ? 0 : 1);

        for (int i = 2; i < nums.length; i++) {
            if (diff != 0 && (nums[i] - nums[i-1]) * diff < 0) {
                count++;
                diff = -diff;
            }
        }
        return count;
    }
}