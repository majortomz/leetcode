package solution300_399;
/**
 * Created by zjw on 2017/11/24.
 */
public class P309_BestTimeToBuyAndSell {

    /*[1,2,3,0,2]
      [1,2,0,5]
            [6,1,3,2,4,7]
    */

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)    return 0;
        int[][] dp = new int[prices.length][prices.length];
        return helper(prices, dp, 0, prices.length - 1);
    }

    public int helper(int[] prices, int[][] dp, int start, int end) {

        int max = 0;
        for(int i = start; i <= end; i++) {
            if(i > start && prices[i] < prices[i - 1]) {
                
            }
        }
        dp[start][end] = Math.max(prices[end] - prices[start], max);
        return dp[start][end];

    }

}
