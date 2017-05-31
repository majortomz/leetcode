package solution500_599;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2017/5/31.
 */
public class P560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return 0;
        int helper[] = new int[nums.length];
        int count = 0;
        // 组成子数组的元素数目
        for(int i = 1; i <= nums.length; i++)
        {
            // 当前元素数目下，子数组的个数
            int end = nums.length - i + 1;
            for(int j = 0; j < end; j++)
            {
                helper[j] = helper[j] + nums[i + j - 1];
                if(helper[j] == k)
                    count++;
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return 0;
        Map<Integer, Integer> map  = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
