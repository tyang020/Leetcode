public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length-1);
    }
    private int binarySearch(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];
        int mid = low + (high - low) / 2;
        if (nums[mid] > nums[high])
            return binarySearch(nums, mid + 1, high);
        else
            return binarySearch(nums, low, mid);
    }
}