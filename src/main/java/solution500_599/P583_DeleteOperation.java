package solution500_599;

/**
 * Created by zjw on 2018/08/20 19:03
 * Description:
 */
public class P583_DeleteOperation {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        dp[0][0] = 0;
        for(int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for(int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        return dp[l1][l2];
    }

}
