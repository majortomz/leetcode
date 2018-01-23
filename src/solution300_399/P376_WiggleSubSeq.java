package solution300_399;

/**
 * Created by zjw on 2018/01/23 16:20
 * Description:
 */
public class P376_WiggleSubSeq {

    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] symbols = new int[nums.length];
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            symbols[i] = 0;
            for(int j = 0; j < i; j++) {
                // symbols[j] == 0 && nums[i] != nums[j] 说明symbols[j]为序列的第一个数
                if((symbols[j] == 0 && nums[i] != nums[j] || symbols[j] * (nums[i] - nums[j]) < 0)
                        && dp[j] + 1 > dp[i]) {
                    symbols[i] = nums[i] - nums[j];
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // from leetcode discussion
    public int wiggleMaxLength2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int p = 1, q = 1;
        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i-1]) {
                p = q + 1;
            } else if(nums[i] < nums[i-1]) {
                q = p + 1;
            }
        }
        return Math.min(len, Math.max(p, q));
    }

}
