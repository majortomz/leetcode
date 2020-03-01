package solution100_199;

/**
 * Created by zjw on 2018/03/24 14:50
 * Description:
 */
public class P123_BestTimeToBuyAndSell3 {

    // from leetcode
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)    return 0;
        // forward[i]  means max profit from 0..i
        // backward[i] means max profit from i..len-1
        int[] forward = new int[prices.length], backward = new int[prices.length];

        int minBuy = prices[0];
        for(int i = 1; i < forward.length; i++) {
            forward[i] = Math.max(forward[i - 1], prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }

        int maxSell = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            backward[i] = Math.max(backward[i + 1], maxSell - prices[i]);
            maxSell = Math.max(prices[i], maxSell);
        }

        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            res = Math.max(res, forward[i] + backward[i]);
        }
        return res;
    }

}
