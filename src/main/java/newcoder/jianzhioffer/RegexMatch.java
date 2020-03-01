package newcoder.jianzhioffer;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/09 16:19
 * Description:
 */
public class RegexMatch {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return helper(str, 0, pattern, 0);
    }


    public boolean helper(char[] str, int m, char[] pattern, int n) {
        if (m == str.length && n == pattern.length) {
            return true;
        }

        if (m != str.length && n == pattern.length) {
            return false;
        }

        if (n + 1 < pattern.length && pattern[n + 1] == '*') {
            if (m != str.length && (pattern[n] == '.' || str[m] == pattern[n])) {
                return helper(str, m + 1, pattern, n + 2) || helper(str, m + 1, pattern, n) || helper(str, m, pattern, n + 2);
            } else {
                return helper(str, m, pattern, n + 2);
            }
        }
        if (m != str.length && (str[m] == pattern[n] || pattern[n] == '.')) {
            return helper(str, m + 1, pattern, n + 1);
        }


        return false;
    }

    public boolean match2(char[] str, char[] pattern) {
        if(str == null || pattern == null)  return false;
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for(int i = 0; i < pattern.length; i++) {
            if(pattern[i] == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for(int i = 0; i < str.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(pattern[j] == '.' || str[i] == pattern[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if(pattern[j] == '*') {
                    if(str[i] != pattern[j - 1] && pattern[j - 1] != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(dp[0]) + " " + Arrays.toString(dp[1]));
        return dp[str.length][pattern.length];
    }

    public static void main(String[] args) {
        RegexMatch rm = new RegexMatch();
        System.out.println(rm.match2(new char[]{'a'}, new char[]{'a', 'b', '*'}));
    }

}
