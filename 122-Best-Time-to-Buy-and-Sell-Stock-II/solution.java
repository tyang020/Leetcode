public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int p : prices) {
            if (p - minPrice > maxProfit)
                maxProfit = p - minPrice;
            else {
                minPrice = p;
                res += maxProfit;
                maxProfit = 0;
            }
        }
        res += maxProfit;
        return res;
    }
}