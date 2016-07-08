public class Solution {
    public int maxProduct(int[] nums) {
        int max_local = nums[0], max_global = nums[0], min_local = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max_local;
            max_local = Math.max(Math.max(max_local*nums[i], nums[i]), min_local*nums[i]);
            // The results of max_local would be the following:
            // 1. min_local < 0 && nums[i] < 0, max_local = max(nums[i], min_local*nums[i])
            // 2. min_local > 0 && nums[i] < 0, max_local = nums[i]
            // 3. nums[i] > 0, max_local = max(nums[i], max_local*nums[i])
            min_local = Math.min(Math.min(min_local*nums[i], nums[i]), temp*nums[i]);
            if (max_local > max_global)
                max_global = max_local;
        }
        return max_global;
    }
}