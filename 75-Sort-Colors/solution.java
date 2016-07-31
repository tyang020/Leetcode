public class Solution {
    public void sortColors(int[] nums) {
        int second = nums.length - 1, zero = 0;
        for (int i = 0; i < second; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero
            }
            else if (nums[i] == 2) {
                nums[i--] = nums[second];
                nums[second--] = 2;
            }
        }
    }
}