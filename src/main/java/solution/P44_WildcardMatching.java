package solution;

/**
 * Created by zjw on 2018/04/17 9:41
 * Description:
 */
public class P44_WildcardMatching {

    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();

        // dp[i][j] 代表s前i个字符是否和前p个字符匹配
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;

        for(int j = 1; j <= plen; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }

        for(int i = 1; i <= slen; i++) {
            for(int j = 1; j <= plen; j++) {
                if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j -1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];  // * match 0次 1次 多次
                }
            }
        }
        return dp[slen][plen];
    }

}
