package solution300_399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2017/8/2.
 */
public class P377_CombinationSum4 {

    int dp[];

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(nums, target);
        return dp[target];
    }

    public int helper(int[] nums,  int target) {
        if(dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for(int i = 0; i < nums.length && nums[i] <= target; i++) {
            res += helper(nums, target - nums[i]);
        }
        dp[target] = res;
        return dp[target];
    }

}

class P377_CombinationSum4_2 {

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        helper(nums, 0, target, map);
        return map.getOrDefault(target, 0);
    }

    public void helper(int[] nums, int sum, int target, Map<Integer, Integer> map) {
        if(sum == target) {
            return;
        }
        int nextT = target - sum;
        for(int i = 0; i < nums.length && nums[i] <= nextT; i++) {
            int tmpSum = sum + nums[i];
            map.put(tmpSum, map.getOrDefault(tmpSum, 0) + 1);
            if(map.getOrDefault(nextT - nums[i], 0) == 0) {
                helper(nums, tmpSum, target, map);
            }
        }
    }

}
