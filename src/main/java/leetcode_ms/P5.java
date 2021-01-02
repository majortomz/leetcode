package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 16:31
 * Description:
 */
public class P5 {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        int n = s.length(), low = 0, high = 0, max = 1;
        char[] words = s.toCharArray();
        boolean[][] dp = new boolean[n][n];

        dp[0][0] = true;
        for(int i = 1; i < n; i++) {
            dp[i][i] = true;
            dp[i - 1][i] = words[i] == words[i - 1];
            if(dp[i - 1][i]) {
                low = i - 1;
                high = i;
                max = 2;
            }
        }

        for(int len = 3; len <= n; len++) {
            for(int i = n - len; i >= 0; i--) {
                int j = i + len - 1;
                dp[i][j] = (dp[i + 1][j - 1] && words[i] == words[j]);
                if(dp[i][j] && len > max) {
                    max = len;
                    low = i;
                    high = j;
                }
            }
        }

        return s.substring(low, high + 1);
    }

}
