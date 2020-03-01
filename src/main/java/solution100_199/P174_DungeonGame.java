package solution100_199;

/**
 * Created by zjw on 2018/04/20 21:01
 * Description:
 */
public class P174_DungeonGame {

    // 不能从左上角开始计算，因为除了要保证已有的路径初始生命值最小，还要考虑剩余的生命值最大。。。

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)    return 0;
        int m = dungeon.length, n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for(int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for(int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }

}
