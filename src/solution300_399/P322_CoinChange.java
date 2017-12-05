package solution300_399;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Created by zjw on 2017/11/28.
 */
public class P322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0)  return -1;
        int dp[] = new int[amount + 1];
        return helper(coins, dp, amount);
    }

    public int helper(int[] coins, int[] dp, int amount) {
        if(dp[amount] != 0 || amount == 0) {
            return dp[amount];
        }
        int min = -1;
        for(int coin : coins) {
            if(amount == coin) {
                min = 1;
                break;
            }
            if(amount > coin) {
                int res = helper(coins, dp, amount - coin);
                if(res == -1)
                    continue;
                min = min == -1 ? res + 1 : Math.min(min, res + 1);
            }
        }
        dp[amount] = min;
        return dp[amount];
    }

}

class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0)  return -1;

        int dp[] = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for(int coin : coins) {
                if(i == coin) {
                    dp[i] = 1;
                    break;
                }
                if(i > coin && dp[i - coin] != -1) {
                    dp[i] = dp[i] == -1 ? dp[i-coin] + 1 : Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount];
    }

}
