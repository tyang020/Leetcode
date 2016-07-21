public class Solution {
    /*
        states:
            buy  : -price(lose money when you buy)
            sell : +price(gain money when you sell)
            
        meaning:
            buy[i] : maxProfit you can get before day i end with 'buy':
                     1. buy on day i - 1, you have to sell before day i-2;
                     2. no trasaction on day i-1, maxProfit is the same as buy[i-1];
                     
            sell[i]: maxProfit you can get before day i end with 'sell':
                     1. sell on day i - 1, you have to buy before day i - 1;
                     2. no trasaction on day i-1, sell[i - 1];
    
        defination:
            buy[i] = max(sell[i-2]-prices[i-1], buy[i-1]);
            sell[i] = max(buy[i-1]+prices[i-1], sell[i-1]);
            
        initial;
            buy[0] = int.min;
            buy[1] = -prices[0];
            sell[0] = 0;
    
    */
    public int maxProfit(int[] prices) {
        int pre_buy, buy = Integer.MIN_VALUE, sell = 0, pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy; //pre_buy = buy[i]
            buy = Math.max(pre_sell - price, pre_buy); // buy[i+1]
            pre_sell = sell; //pre_sell = sell[i];
            sell = Math.max(pre_buy + price, pre_sell); //sell[i+1]
        }
        return sell;
    }
}