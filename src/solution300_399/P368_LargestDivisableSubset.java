package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2018/01/22 17:03
 * Description:
 */
public class P368_LargestDivisableSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int[] dp = new int[nums.length], pre = new int[nums.length];
        int max = 0, index = 0;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        while(index != -1) {
            result.add(0, nums[index]);
            index = pre[index];
        }
        return result;
    }

}
