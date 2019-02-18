package leetcode_ms;

/**
 * Created by zjw on 2018/08/07 9:38
 * Description:
 */
public class P213 {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length <= 2) {
            return Math.max(nums[0], nums[nums.length - 1]);
        }

        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int start, int end) {
        int[][] dp = new int[nums.length][2];
        dp[start][0] = nums[start];

        for(int i = start + 1; i <= end; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[end][0], dp[end][1]);
    }

}
