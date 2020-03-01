package solution300_399;

/**
 * Created by zjw on 2018/03/24 16:13
 * Description:
 */
public class P309_BestTimeToBuyAndSellCooldown {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)    return 0;
        int len = prices.length;
        int[] buy = new int[len], sell = new int[len], rest = new int[len];
        buy[0] = -prices[0];
        for(int i = 1; i < len; i++) {
            buy[i] = Math.max(rest[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            rest[i] = Math.max(sell[i - 1], rest[i - 1]);
        }
        return Math.max(rest[len - 1], sell[len - 1]);
    }

}
