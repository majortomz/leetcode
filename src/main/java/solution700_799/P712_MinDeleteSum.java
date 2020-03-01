package solution700_799;

/**
 * Created by zjw on 2018/03/11 10:05
 * Description:
 */
public class P712_MinDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int lenA = s1.length(), lenB = s2.length();

        // init
        for(int i = 1; i <= lenB; i++) {
            dp[0][i] = dp[0][i - 1] + c2[i - 1];
        }
        for(int i = 1; i <= lenA; i++) {
            dp[i][0] = dp[i- 1][0] + c1[i - 1];
        }

        // cal
        for(int i = 1; i <= lenA; i++) {
            for(int j = 1; j <= lenB; j++) {
                if(c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(c1[i - 1] + dp[i - 1][j], c2[j - 1] + dp[i][j - 1]);
                }
            }
        }
        return dp[lenA][lenB];
    }

}
