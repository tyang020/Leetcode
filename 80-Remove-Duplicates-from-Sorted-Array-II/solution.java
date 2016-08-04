public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int dup = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // If # of duplicates is greater than 2, check next element;
            if (dup == 2 && nums[i-1] == nums[i])
                continue;
            
            // dup is less than 2:
            if (nums[i - 1] == nums[i])
                dup++;
            else
                dup = 1;
            count++;
            nums[count - 1] = nums[i];
        }
        return count;
    }
}