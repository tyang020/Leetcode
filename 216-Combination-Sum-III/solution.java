public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        combination(res, list, k, 1, n);
        return res;
    }
    private void combination(List<List<Integer>> res, List<Integer> comb, int k, int start, int n) {
        if (comb.size() > k) {
            return;
        }
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            res.add(li);
            return;
        }
        for (int i = start; i<=9; i++) {
               if (n-i >= 0) {
                   comb.add(i);
                   combination(res, comb, k, i+1, n-i);
                   comb.remove(comb.size() - 1);
               }

        }
        /*
        if (k == 0 && n != 0)
            return;
        
        if (k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = (list.isEmpty() ? 1 : (list.get(list.size()-1) + 1)); i <= Math.min(n, 9); i++) {
            list.add(i);
            combination(res, list, k - 1, n - i);
            list.remove(list.size() - 1);
        }
        */
    }
}