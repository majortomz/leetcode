package solution100_199;

/**
 * Created by zjw on 2018/04/19 15:39
 * Description:
 */
public class P115_DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int[] dp = new int[t.length() + 1];

        dp[0] = 1;
        int prev;
        for(int i = 1; i <= s.length(); i++) {
            prev = dp[0];  // reserve dp[j - 1]
            for(int j = 1; j <= t.length(); j++) {
                int tmp = dp[j];
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += prev;
                }
                prev = tmp;
            }
        }
        return dp[t.length()];
    }

    public int numDistinct2(String s, String t) {

        if(s.length() < t.length()) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}
