public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Add nums[i] to res list, find another three numbers after position i which sum up to target - num[i]
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 4) return res;
        Arrays.sort(nums);
        int last2sum = nums[n-1]+nums[n-2], last3sum = nums[n-3]+last2sum;
        
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] * 4 > target)            // nums[i] is too large
                break;
            if (i != 0 && nums[i] == nums[i-1])   // skip duplicate
                continue;
            if (nums[i] + last3sum < target)       // nums[i] is too small
                continue;
            
            // Find three elements sum to target - nums[i]
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[j] * 3 > target - nums[i])
                    break;
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (nums[j] + nums[i] + last2sum < target)
                    continue;
                    
                // find two elements sum to target - nums[i] - nums[j] in O(n) time
                int left = j + 1, right = n - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target)
                        right--;
                    else
                        left++;
                }
            }
        }
        return res;
    }
}