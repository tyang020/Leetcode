public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        // Reference: http://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
        
        int[] s = new int[nums.length];  // s[i] saves the index of smallest integer that ends an increasing sequence of length i+1;
        int[] prev = new int[nums.length]; // prev[i] saves the predecessor's index of nums[i] in the resulting LIS
        Arrays.fill(prev, -1);
        int len = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[s[0]])
                s[0] = i;
            else if (nums[i] > nums[s[len]]){
                prev[i] = s[len];
                len++;
                s[len] = i;
            } else {
                int lo = 1, hi = len;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (nums[s[mid]] >= nums[i])
                        hi = mid;
                    else
                        lo = mid + 1;
                }
                //nums[s[lo]] is the first element which is no less than nums[i]
                s[lo] = i;
                prev[i] = s[lo-1];
            }
        }
        // the last element is nums[s[len]], its predecessor is nums[prev[s[len]]]..., find all elements until prev[i] = -1.
        return len+1;
    }
}