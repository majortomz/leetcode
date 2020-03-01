package solution500_599;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2017/8/22.
 */
public class P523_ContinousSubarrSum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j + i < nums.length; j++) {
                dp[j] += nums[j+i];
                if(dp[j] == k || k != 0 && dp[j] % k == 0)  return true;
            }
        }
        return false;
    }

    // Solution 2: from leetcode discussion
    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0, -1);}};
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0)  sum %= k;
            Integer prev = map.get(sum);
            if(prev != null) {
                if(i - prev > 1)    return true;
            }
            else
                map.put(sum, i);
        }
        return false;
    }
}
