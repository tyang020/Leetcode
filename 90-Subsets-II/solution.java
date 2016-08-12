public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        Arrays.sort(nums);
        
        if (nums.length != 0)
            res.add(Arrays.asList(nums[0]));
            
        int start = 0, size = 1;
        
        for (int i = 1; i < nums.length; i++) {
            start = (nums[i] == nums[i-1]) ? size : 0;
            size = res.size();
            for (int j = start; j < size; j++) {
                List<Integer> list = new ArrayList(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}