public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        combination(res, list, candidates, target, 0);
        return res;
    }
    private void combination(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (target < candidates[start])
            return;
            
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            combination(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}