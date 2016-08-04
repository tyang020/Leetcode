public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (count < 2 || num != nums[count-2]) // This condition guarantees that the num you want to move forward has to
                                                  // be not equal to the one before its previous element, which means there are
                                                  // at most 2 same element before index count.
                nums[count++] = num; 
        }
        
        return count;
    }
}