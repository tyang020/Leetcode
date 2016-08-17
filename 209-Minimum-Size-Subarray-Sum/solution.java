public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0; // save the start and end position of when sum >= s, we can get the current min length by end-start;
        int sum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end++];
            
            // Once sum >= s, we throw the front elements to reduce the length to minimum until sum < s
            while (sum >= s) {
                if (end - start < min)
                    min = end - start;
                sum -= nums[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}