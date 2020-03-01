package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2017/6/9.
 */
public class P18_4Sum {

    // Solution 1: O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 3)  return res;
        Arrays.sort(nums);
        int last = nums.length - 4;
        for(int i = 0; i <= last; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j-1])   continue;
                int sum = target - nums[i] - nums[j];
                int left = j + 1, right = nums.length - 1;
                while(left < right) {
                    int tmp = nums[left] + nums[right];
                    if(tmp == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(right > left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if(tmp < sum)
                        left++;
                    else
                        right--;
                }
            }
        }
        return res;
    }
}
