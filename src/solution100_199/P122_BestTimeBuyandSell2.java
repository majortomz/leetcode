package solution100_199;

/**
 * Created by zjw on 2017/5/16.
 */
public class P122_BestTimeBuyandSell2 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)  return 0;
        int res = 0;
        for(int i=1; i < prices.length; i++) {
            if(prices[i] > prices[i-1])
                res += (prices[i] - prices[i-1]);
        }
        return res;
    }
}
