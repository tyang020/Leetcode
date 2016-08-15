public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> list = new ArrayList(triangle.get(n-1));
        int[] min_path_sum = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            min_path_sum[i] = list.get(i);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int j = 0; j <= row; j++){
                min_path_sum[j] = Math.min(min_path_sum[j], min_path_sum[j+1]) + triangle.get(row).get(j);
            }
        }
        return min_path_sum[0];
    }
}