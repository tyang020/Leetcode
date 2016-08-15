public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] len = new int[nums.length]; // len[i]: the length - 1 of largest divisible subset end with nums[i]
        int[] prev = new int[nums.length]; // prev[i]: the previous element of nums[i] in the LDS
        Arrays.fill(prev, -1);
        int max = Integer.MIN_VALUE, maxidx = -1;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && len[j] < len[i]+1) {
                    len[j] = len[i] + 1;
                    prev[j] = i;
                }
            }
            if (len[i] > max) {
                max = len[i];
                maxidx = i;
            }
        }
        
        List<Integer> res = new ArrayList();
        while(maxidx != -1) {
            res.add(0, nums[maxidx]);
            maxidx = prev[maxidx];
        }
        return res;
    }
}