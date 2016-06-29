public class Solution {
    public int removeDuplicates(int[] nums) {
        // i keeps track of the original array and j keeps track of the new array.
        // nums[j] overwirtes nums[i]
        int i, j = 0;
        for(i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) 
                nums[j++] = nums[i];
            else if(nums[i] != nums[i + 1] ) {
                nums[j++] = nums[i];
            }
            
        }
        return j;
    }
}