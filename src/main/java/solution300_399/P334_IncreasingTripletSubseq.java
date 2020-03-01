package solution300_399;

/**
 * Created by zjw on 2018/01/17 9:28
 * Description:
 */
public class P334_IncreasingTripletSubseq {

    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return false;
        }
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] == 3)
                        return true;
                }
            }
        }
        return false;
    }

    // solution 2 from leetcode discussion
    public boolean increasingTriplet2(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return false;
        }
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n <= min) {
                min = n;
            } else if(n <= max) {
                max = n;
            } else {
                return true;
            }
        }
        return false;
    }

}
