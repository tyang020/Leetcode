public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            
            // Normal sorted array before mid:
            if (nums[low] <= nums[mid]) {
                if (target > nums[mid] || target < nums[low])
                    low = mid + 1;
                else
                    high = mid;
            }
            // Normal sorted array after mid:
            else {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        return nums[low] == target ? low : -1;
    }
}