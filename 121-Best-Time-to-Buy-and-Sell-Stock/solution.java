public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int p : prices) {
            if (p < minPrice)
                minPrice = p;
            else if (p - minPrice > maxProfit)
                maxProfit = p - minPrice;
        }
        return maxProfit;
    }
}