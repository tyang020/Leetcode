public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums.length == 0)
            return res;
        
        permutation(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void permutation(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        if (list.size() == nums.length) {
            res.add(list);
            return;
        }
        
        // find a postion to insert current number nums[pos];
        // i.e. list = {2,4,5,1}, nums[pos] = 3, 3 can be inserted to 0,1,2,3,4
        for (int i = 0; i <= list.size(); i++) {
            List<Integer> newl = new ArrayList(list);
            newl.add(i, nums[pos]);
            permutation(res, newl, nums, pos+1);
        }
    }
}