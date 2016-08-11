public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        
        for (int i = 1; i <= n; i++) res.add(Arrays.asList(i));
        
        // In iteration i, the length of each element in res is going to be i;
        for(int i = 2; i <= k; i++) {
            List<List<Integer>> new_res = new ArrayList();
            for (List<Integer> l : res) {
                for (int j = l.get(l.size()-1)+1; j <= n; j++) {
                    List<Integer> newl = new ArrayList(l);
                    newl.add(j);
                    new_res.add(newl);
                }
            }
            res = new_res;
        }
        
        return res;
    }
}