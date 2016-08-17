public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int reach = 0; // reach defines the furthest position we can reach when we arrive at position i
        for (int i = 0; i <= reach; i++) {
            if (reach >= len - 1)
                return true;
            if (i+nums[i] > reach)
                reach = i + nums[i];
        }
        return false;
    }
}