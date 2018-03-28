package solution100_199;

/**
 * Created by zjw on 2018/03/24 15:20
 * Description:
 */
public class P188_BestTimeToBuyAndSell4 {

    public int maxProfit(int k, int[] prices) {

        // as many as transactions we can
        if(k >= prices.length / 2) {
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // dp[i][j] represents max profits until prices[j] with at most i transaction;
        // dp[i][j] = max(dp[i][j - 1], prices[j] - prices[jj - 1] + dp[i - 1][jj])  0 <= jj <= j - 1
        // dp[0][j] = 0
        // dp[i][0] = 0
        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for(int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];

    }

}
