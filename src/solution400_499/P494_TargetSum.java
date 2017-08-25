package solution400_499;

/**
 * Created by zjw on 2017/8/22.
 */
public class P494_TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0)    return 0;
        return helper(nums, nums.length, S);
    }

    public int helper(int[] nums, int count, int sum) {
        if(count == 1)  {
            if(nums[0] == sum)  return 1;
            else    return 0;
        }
        count--;
        return helper(nums, count, sum - nums[count]) +
                helper(nums, count, sum + nums[count]);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int i : nums)   sum += i;
        if(sum < Math.abs(S)) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for(int i = 0; i < nums.length; i++) {
            int[] next = new int[dp.length];
            for(int j = 0; j < dp.length; j++) {
                if(dp[j] != 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }

}
