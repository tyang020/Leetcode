public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Math.MAX_VALUE, maxProfit = 0;
        for(int p : prices) {
            if (p - minPrice > maxProfit)
                maxProfit = p - minPrice;
            if (p < minPrices)
                minPrices = p;
        }
        return maxProfit;
    }
}