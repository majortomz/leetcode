package solution800_899;

/**
 * Created by zjw on 2018/07/29 10:58
 * Description:
 */
public class P879_ProfitableSchmes {

    // from leetcode discussion
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = 1_000_000_007;
        int n = group.length;

        long[][][] dp = new long[2][P + 1][G + 1];
        dp[0][0][0] = 1;

        for(int i = 0; i < n; i++) {
            int g0 = group[i], p0 = profit[i];

            long[][] cur = dp[i % 2], cur2 = dp[(i + 1) % 2];

            for(int jp = 0; jp <= P; jp++) {
                for(int jg = 0; jg <= G; jg++) {
                    cur2[jp][jg] = cur[jp][jg];
                }
            }

            for(int p1 = 0; p1 <= P; p1++) {
                int p2 = Math.min(P, p1 + p0);
                for(int g1 =0; g1 <= G - g0; g1++) {
                    int g2 = g1 + g0;
                    cur2[p2][g2] += cur[p1][g1];
                    cur2[p2][g2] %= mod;
                }
            }
        }

        long res = 0;
        for(long num: dp[n % 2][P]) {
            res += num;
        }
        return (int)(res % mod);
    }
}
