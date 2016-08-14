public class Solution {
    public int lengthOfLIS(int[] nums) {
        /** Suppose you want to find the longest increasing subsequence length before index i
         *  1. Find the longest increasing subsequence length at each position from index 0 to i-1, saved in array res;
         *  2. For those numbers nums[j](0 <= j < i) which are less than nums[i], res[i] = max(res[j]+1, res[i]);
         *  3. Search for maximum length in array res from index 0 to index i;
         *  The time complexity is O(n^2)
         */
         if (nums.length == 0)
            return 0;
         int[] res = new int[nums.length];
         Arrays.fill(res, 1);
         
         for (int i = 0; i < nums.length; i++) {
             for (int j = 0; j < i; j++) {
                 if (nums[j] < nums[i])
                    res[i] = Math.max(res[i], res[j]+1);
             }
         }
         
         int length = 1;
         for (int n : res) {
             if (n > length)
                length = n;
         }
         return length;
    }
}