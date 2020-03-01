package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2017/8/23.
 */
public class P486_PredictWinner {

    public boolean predictTheWinner(int[] nums) {
        if(nums == null || nums.length <= 1)  return true;
        int dp[][] = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], -1);
        helper(nums, 0, nums.length-1, dp, 1);
        return dp[0][nums.length-1] >= 0;
    }

    public int helper(int[] nums, int lt, int rt, int dp[][], int flag) {
        if(lt > rt)    return 0;
        if(dp[lt][rt] >= 0)  return dp[lt][rt];

        int ra = flag * nums[lt] + helper(nums, lt+1, rt, dp, flag * -1);
        int rb = flag * nums[rt] + helper(nums, lt, rt-1, dp, flag * -1);
        if(flag > 0)
            dp[lt][rt] = Math.max(ra, rb);
        else
            dp[lt][rt] = Math.min(ra, rb);
        return dp[lt][rt];
    }

    // from leetcode discussion
    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) { dp[i][i] = nums[i]; }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
