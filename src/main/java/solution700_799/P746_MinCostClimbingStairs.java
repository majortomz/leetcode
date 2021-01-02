package solution700_799;

/**
 * Created by zjw on 2018/03/01 11:35
 * Description:
 */
public class P746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        if(cost.length <= 2)    return 0;
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
        }
        return Math.min(dp[dp.length - 2], dp[dp.length - 1]);

    }

}
