public class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            
            if (nums[low] < nums[mid]) {
                if (target > nums[mid] || target < nums[low])
                    low = mid + 1;
                else
                    high = mid;
            } else if (nums[low] > nums[mid]) {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid;
            } else {
                low++;  // when there are duplicates, we need to traverse all the elements in nums array.
            }
        }
        
        return nums[low]==target;
    }
}