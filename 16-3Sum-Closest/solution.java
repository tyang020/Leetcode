public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        if (nums.length < 3) {
            for (int n : nums)
                res += n;
            return res;
        }
        Arrays.sort(nums);
        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int curSum = nums[lo] + nums[hi] + nums[i];
                
                if (Math.abs(target - curSum) < Math.abs(target - res)) {
                    if (target - curSum == 0) return curSum;
                    res = curSum;
                }
                if (target - curSum > 0) {
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    lo++;
                } else {
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    hi--;
                }
            }
        }
        return res;
    }
}