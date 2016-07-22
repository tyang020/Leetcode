public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int diff = nums[1] - nums[0], count = 2;
        int i = 1;
        while (diff == 0 && i < nums.length) {
            i++;
            count = 1;
        }
        for ( ; i < nums.length; i++) {
            if (diff == 0) continue;
            if ((nums[i] - nums[i-1]) * diff < 0) {
                count++;
                diff = -diff;
            }
        }
        return count;
    }
}