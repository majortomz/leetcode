package leetcode_ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/08/05 21:26
 * Description: 3sum
 */
public class P15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                if(start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if(end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                if(nums[start] + nums[end] == target) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if(nums[start] + nums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return res;
    }

}
