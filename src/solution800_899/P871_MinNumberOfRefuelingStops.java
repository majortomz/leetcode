package solution800_899;

/**
 * Created by zjw on 2018/07/15 10:14
 * Description:
 */
public class P871_MinNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int len = stations.length;
        int[][] dp = new int[len + 1][len + 1];
        dp[0][0] = startFuel;

        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if(dp[i - 1][j] >= stations[i - 1][0]) {
                    dp[i][j + 1] = dp[i - 1][j] + stations[i - 1][1];
                }
            }
        }

        for(int i = 0; i <= len; i++) {
            if(dp[len][i] >= target) {
                return i;
            }
        }
        return -1;
    }

}
