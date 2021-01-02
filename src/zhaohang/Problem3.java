package zhaohang;

import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0)  System.out.println(0);

        if (n == 1) System.out.println(1);

        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2)
                p2++;
            if(dp[i] == dp[p3] * 3)
                p3++;
            if(dp[i] == dp[p5] * 5)
                p5++;
        }

        System.out.println(dp[n - 1]);
    }
}
