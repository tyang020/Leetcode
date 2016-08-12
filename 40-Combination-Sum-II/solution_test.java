public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        calcCombinationSum2(candidates, 0, new int[candidates.length], 0, target, results);
        return results;
    }
    
    private void calcCombinationSum2(int[] candidates, int cindex, int[] list, int lindex, int target, List<List<Integer>> results) {
        if (target == 0) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < lindex; i++) {
                result.add(list[i]);
            }
            results.add(result);
            return;
        }
        
        int prev = 0;
        for (int i = cindex; i < candidates.length; i++) {
            if (candidates[i] != prev) {
                if (target - candidates[i] < 0) {
                    break;
                }
                
                list[lindex] = candidates[i];
                calcCombinationSum2(candidates, i + 1, list, lindex + 1, target - candidates[i], results);
                prev = candidates[i];
            }
        }
    }
}