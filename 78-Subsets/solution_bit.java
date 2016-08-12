public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Use a nums.length-bit number to represent the status of each nums whether it appear or not in this subset
        // i.e. nums={1,2,3} 
        //      subsets      number
        //         3           001
        //        1,2          110
        List<List<Integer>> res = new ArrayList();
        
        int n = 1 << nums.length;
        for (int i = 0; i < n; i++) {
            // Get one subset corresponding to number i
            List<Integer> list = new ArrayList();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0)
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
}