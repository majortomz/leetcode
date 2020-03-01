package solution;

import java.util.Arrays;

/**
 * Created by zjw on 2018/04/12 22:03
 * Description:
 */
public class P10_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int lens = s.length(), lenp = p.length();
        // dp[i][j]  代表s的前i个字符是否匹配p的前j个字符
        // p[j] == '.'时  dp[i][j] = dp[i - 1][j - 1]
        // p[j] == '*'时  dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 1] || dp[i - 1][j]  匹配0个 匹配1个 匹配n > 1个
        boolean[][] dp = new boolean[lens + 1][lenp + 1];

        dp[0][0] = true;
        for(int j = 1; j <= lenp; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for(int i = 1; i <= lens; i++) {
            for(int j = 1; j <= lenp; j++) {
                char c = p.charAt(j - 1);
                if(c == '.' || c == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(c == '*') {
                    if(p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = (dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
//        for(boolean[] arr : dp) {
//            System.out.println(Arrays.toString(arr));
//        }
        return dp[lens][lenp];
    }

}
