package toutiao;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {


    private static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner("3 2 5\n1 2 3\n1 2");
//        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n1], b = new int[n2];
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        long res = 0;
        int[][] dp1 = new int[n1 + 1][m + 1], dp2 = new int[n2 + 1][m + 1];
        for(int i = 1; i <= n1; i++) {
            dp1[i][0] = 1;
            int tmp = a[i - 1];
            while(tmp <= m)  {
                dp1[i][tmp] = 1;
                tmp += a[i - 1];
            }
            for(int j = 1; j <= m; j++) {
                tmp = a[i - 1];
                while(j > tmp) {
                    dp1[i][j] += dp1[i - 1][j - tmp];
                    tmp += a[i - 1];
                }
                dp1[i][j] += dp1[i - 1][j];
            }
        }
//        System.out.println(Arrays.toString(dp1[n1]));

        for (int i = 1; i <= n2; i++) {
            dp2[i][0] = 1;
            if(b[i - 1] <= m)   dp2[i][b[i - 1]] = 1;
            for (int j = 1; j <= m; j++) {
                dp2[i][j] += (j > b[i - 1] ? dp2[i - 1][j - b[i - 1]] : 0) + dp2[i - 1][j];
            }
        }

        for (int i = 0; i <= m; i++) {
            res += dp2[n2][i] * dp1[n1][m - i];
            res %= MOD;
        }

        System.out.println(res);
    }

    private static int combination(int[] a, int start, int target) {
        if (target == 0) return 1;
        if (start >= a.length || target < 0) return 0;

        int res = combination(a, start + 1, target);
        while (target >= a[start]) {
            target -= a[start];
            res += combination(a, start + 1, target);
            res %= MOD;
        }
        res %= MOD;
        return res;
    }

}
