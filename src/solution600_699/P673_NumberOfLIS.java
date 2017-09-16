package solution600_699;

/**
 * Created by zjw on 2017/9/12.
 */
public class P673_NumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int max = 1, count = 0;
        int[][] dp = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            if(dp[i][0] == max)
                count++;
            for(int j = 0; j < i; j++) {
                if(nums[j] >= nums[i])  continue;
                int tmpLen = dp[j][0] + 1;

                if(tmpLen > dp[i][0]) {
                    dp[i][0] = tmpLen;
                    dp[i][1] = dp[j][1];
                }
                else if(tmpLen == dp[i][0]) {
                    dp[i][1] += dp[j][1];
                }

                if(tmpLen > max) {
                    count = dp[j][1];
                    max = tmpLen;
                }
                else if(tmpLen == max)
                    count += dp[j][1];

            }
        }
        return count;
    }

}
