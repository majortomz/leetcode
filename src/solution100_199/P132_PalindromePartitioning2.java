package solution100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/9/26.
 */
public class P132_PalindromePartitioning2 {

    public int minCut(String s) {
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cuts = new int[s.length()];

        // calculate palindrome
        for(int i = 0; i < str.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(str[j] == str[i] && (i - j <= 2 || dp[j+1][i-1]))
                    dp[j][i] = true;
            }
        }
        helper(cuts, dp, 0);
        return cuts[0];

    }

    public void helper(int[] cuts, boolean[][] dp, int start) {
        if(start >= dp.length)  {
            return;
        }

        if(dp[start][dp.length - 1]) {
            cuts[start] = 0;
            return;
        }

        int min = dp.length;

        for(int i = start; i < dp.length; i++) {
            if(!dp[start][i])   continue;
            helper(cuts, dp, i + 1);
            min = Math.min(min, 1 + cuts[i+1]);
        }
        cuts[start] = min;
    }

    // Solution 2: leetcode discussion
    public int minCut2(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

}
