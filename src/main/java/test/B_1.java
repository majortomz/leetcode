package test;

import java.util.Arrays;

/**
 * Created by zjw on 2018/09/26 19:53
 * Description:
 */
public class B_1 {

    public static int minGasStation(int numOfGS, int[] distOfGS, int[] allowedGasoline, int distance, int initialGasoline) {

        int n = numOfGS;
        int[][] gas = new int[n][n];
        for(int i = 0; i < n; i++) {
            gas[i][0] = distOfGS[i];
            gas[i][1] = allowedGasoline[i];
        }

        Arrays.sort(gas, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[n + 1][n + 1];

        dp[0][0] = initialGasoline;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if(dp[i - 1][j] >= gas[i - 1][0]) {
                    dp[i][j + 1] = dp[i - 1][j] + gas[i - 1][1];
                }
            }
        }

        for(int i = 0; i <= n; i++) {
            if(dp[n][i] >= distance) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        System.out.println(minGasStation(4, new int[]{5, 7, 8, 10}, new int[]{2, 3, 1, 5}, 15, 5));

    }

}
