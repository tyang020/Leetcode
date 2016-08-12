public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int lo = 0, hi = nums.length - 1;
        
        // Search for start
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid])
                lo = mid + 1;
            else
                hi = mid;
        }
        if (nums[lo] != target)
            return res;
        
        res[0] = lo;
        
        // Search for end
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid])
                hi = mid - 1;
            else
                lo = mid;
        }
        res[1] = lo;
        return res;
    }
}