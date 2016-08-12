public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /**
         * Take [1, 2, 3] in the problem statement as an example. The process of generating all the subsets is like:
            * Initially: [[]]
            * Adding the first number to all the existed subsets: [[], [1]];
            * Adding the second number to all the existed subsets: [[], [1], [2], [1, 2]];
            * Adding the third number to all the existed subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
        */
        
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        // At each iteration, add nums[i] to every existed list in res
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}