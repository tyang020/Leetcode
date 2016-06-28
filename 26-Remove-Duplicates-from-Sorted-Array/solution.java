public class Solution {
    public int removeDuplicates(int[] nums) {
        int i, j = 0;
        // i keeps track of the original array and j keeps track of the new array.
        // nums[j] overwirtes nums[i]
        for(int i, j = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]) {
                nums[j++] = nums[i];
            }
        }
        nums[j] = nums[i];
        return j;
    }
}