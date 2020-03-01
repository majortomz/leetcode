package solution800_899;

/**
 * Created by zjw on 2018/04/03 16:33
 * Description:
 */
public class P808_SoupServings {

    // from leetcode discussion
    double[][] dp = new double[300][300];

    public double soupServings(int N) {
//        return N >= 4800 ? 1.0 : dfs((N + 24) / 25, (N + 24) / 25);
        return dfs((N + 24) / 25, (N + 24) / 25);
    }

    private double dfs(int a, int b) {
        if(a <= 0 && b <= 0)    return 0.5;
        if(a <= 0) return 1;
        if(b <= 0) return 0;
        if(dp[a][b] > 0)    return dp[a][b];
        dp[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs( a - 2, b - 2) + dfs(a -1, b - 3));
        return dp[a][b];
    }

    public static void main(String[] args) {
        P808_SoupServings ps = new P808_SoupServings();
        System.out.println(ps.soupServings(5000));
    }
}
