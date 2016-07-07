public class Solution {
    public void rotate(int[] nums, int k) {
        /** Solution2: O(n) time and O(1) space */
        if (k > nums.length)
            k = k % nums.length;
        int n = nums.length;
        
        /** Reverser the left part and right part, then reverse the whole array */
        for (int i = 0; i < (n - k) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n-k-1-i];
            nums[n-k-1-i] = temp;
        }
        
        for (int i = n - k; i < n - k/2; i++) {
            int temp = nums[i];
            nums[i] = nums[2*n-k-i-1];
            nums[2*n-k-i-1] = temp;
        }
        for (int i = 0; i < n/2; i++) {
            int temp = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = temp;
        }
    }
}