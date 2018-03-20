package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zjw on 2018/03/16 17:37
 * Description:
 */
public class Main {

    public static long count(int n) {
        if (n == 0)
            return 0;
        int coins[] = { 1, 5, 10, 20, 50, 100 };
        int h = coins.length;
        long dp[][] = new long[h][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < h; i++) {
            for (int j = 1; j <= n; j++) {
                int m = j / coins[i];
                for (int k = 0; k <= m; k++) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[h - 1][n];
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int target = sc.nextInt();
            int count = 0;
            // cal
            long res = count(target);
            System.out.println(count);
        }
    }

}
