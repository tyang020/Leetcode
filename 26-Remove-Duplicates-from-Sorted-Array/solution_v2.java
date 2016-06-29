public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        //n: original array
        //nums[i]: new array without duplicates
        for(int n : nums) {
            if (i < 1 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}