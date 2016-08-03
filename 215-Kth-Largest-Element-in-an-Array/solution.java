public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //https://discuss.leetcode.com/topic/15256/4-c-solutions-using-partition-max-heap-priority_queue-and-multiset-respectivel
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k-1)
                return nums[pos];
            if(pos < k-1)
                left = pos + 1;
            else
                right = pos - 1;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // This function partition the nums into two parts:
    // Return the postion of pivot, and all the left number of pivot is larger than pivot, whereas all the right nums of pivot is smaller or equal to pivot
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1, r = right;
        // Store all the nums which are larger than pivot to the left
        // Check from the tail of the array, if it is larger than pivot, move it to left
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot)
                swap(nums[l++], nums[r--]);
            if (nums[l] >= pivot) l++; 
            if (nums[r] <= pivot) r--;
            /*if (nums[r] > pivot)
                swap(nums, l++, r);
            else
                r--;
            */
        }
        swap(nums, left, r);
        return r;
    }
}