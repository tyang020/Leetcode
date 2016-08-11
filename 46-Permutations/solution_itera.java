public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums.length == 0)
            return res;
        
        List<Integer> l = new ArrayList();
        l.add(nums[0]);
        res.add(l);
        
        for (int i = 1; i < nums.length; i++) {
            
            while(res.get(0).size() == i) {
                
                for (int pos = 0; pos <= i; pos++) {
                    List<Integer> newl = new ArrayList(res.get(0));
                    newl.add(pos, nums[i]);
                    res.add(newl);
                }
                res.remove(0);
            }
        }
        
        return res;
    }
}