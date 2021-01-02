package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2017/9/16.
 */
public class P416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1)    return false;
        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum % 2 != 0)    return false;
        sum /= 2;

        // can use only one dimension array
        boolean[][] dp = new boolean[nums.length][sum+1];
        dp[0][0] = dp[0][nums[0]] = true;
        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = true;
            int last = i - 1;
            for(int j = 0; j <= sum; j++) {
                if(dp[last][j]) {
                    dp[i][j] = true;
                    if(j + nums[i] <= sum)
                        dp[i][j + nums[i]] = true;
                }
            }
            if(dp[i][sum])  return true;
        }

        return false;
    }

}
