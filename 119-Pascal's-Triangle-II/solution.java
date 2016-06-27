public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = null;
        List<Integer> res = null;
        for (int i = 0; i <= rowIndex; i++) {
            res = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) 
                res.add(j == 0 || j == i ? 1 : pre.get(j-1) + pre.get(j));
            pre = res;
        }
        return res;
    }
}