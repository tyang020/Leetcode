public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        helper(res, new ArrayList(), nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList(list));
        
        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i != start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            helper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}