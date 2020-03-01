package solution700_799;

/**
 * Created by zjw on 2018/03/25 13:31
 * Description:
 */
public class Problem_714 {

    // 13:31
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length <= 1)    return 0;

        int len = prices.length - 1;
        int[] buy = new int[prices.length], sell = new int[prices.length];
        buy[0] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(prices[i] + buy[i - 1] - fee, sell[i - 1]);
        }

        return Math.max(buy[len], sell[len]);
    }

}
