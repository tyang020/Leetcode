public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows != 0)
            res.add(new ArrayList(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            List<Integer> preList = res.get(i-1);
            curList.add(1);
            for (int j = 0; j < i - 1; j++) {
                curList.add(preList.get(j)+preList.get(j+1));
            }
            curList.add(1);
            res.add(curList);
        }
        return res;
    }
}