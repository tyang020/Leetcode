public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList();
        if(nums.length ==0)
            return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, visited);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i-1] == nums[i] && !visited[i-1]) continue; // This makes sure that all the duplicate values will be add to list in order from start to end.
            
            visited[i] = true;
            list.add(nums[i]);
            
            helper(res, list, nums, visited);
            
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
    
}