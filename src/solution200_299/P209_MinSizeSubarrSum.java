package solution200_299;

/**
 * Created by zjw on 2017/6/10 16:48.
 */
public class P209_MinSizeSubarrSum {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)  return 0;
        int len = nums.length, left = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum < s) continue;
            while(left < i && sum - nums[left] >= s) {
                sum -= nums[left];
                left++;
            }
            len = Math.min(len, i - left + 1);
        }
        return sum >= s ? len : 0;
    }

}
