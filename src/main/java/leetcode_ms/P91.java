package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 10:55
 * Description:
 */
public class P91 {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] dp = new int[n][n];
        char[] digits = s.toCharArray();

        dp[0][0] = digits[0] == '0' ? 0 : 1;
        for(int i = 1; i < n; i++) {
            dp[i][i] = (digits[i] == '0' ? 0 : 1);
            if(dp[i][i] == 1 && dp[i - 1][i - 1] == 1) {
                dp[i - 1][i] = 1;
            }
            if(isValid(digits, i - 1, i)){
                dp[i - 1][i] += 1;
            }
        }

        for(int len = 3; len <= n; len++) {
            for(int i = n - len; i >= 0; i--) {
                int j = i + len - 1;
                dp[i][j] = dp[i][i] * dp[i + 1][j] + Math.max(dp[i][i + 1] - dp[i + 1][i + 1], 0)* dp[i + 2][j];
            }
        }
        return dp[0][n - 1];
    }

    private boolean isValid(char[] digits, int i, int j) {
        if(i == j) {
            return digits[i] != '0';
        }
        if(i + 1 == j && digits[i] != '0') {
            int b = (digits[i] - '0') * 10 + digits[j] - '0';
            return b >= 1 && b <= 26;
        }
        return false;
    }


}
