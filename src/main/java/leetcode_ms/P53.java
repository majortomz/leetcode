package leetcode_ms;

/**
 * Created by zjw on 2018/07/19 10:44
 * Description:
 */
public class P53 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0], prevSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prevSum = Math.max(prevSum + nums[i], nums[i]);
            maxSum = Math.max(prevSum, maxSum);
        }
        return maxSum;
    }
}
