public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        combination(res, list, candidates, target, 0);
        return res;
    }
    private void combination(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //Remove duplicate: if i != start, then list does not contain cand[i](add then remove)
            if (i != start && candidates[i] == candidates[i-1])
                continue;
            list.add(candidates[i]);
            combination(res, list, candidates, target - candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }
}