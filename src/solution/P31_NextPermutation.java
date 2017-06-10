package solution;

import java.util.Arrays;

/**
 * Created by zjw on 2017/6/3.
 */
public class P31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)    return;
        int top = nums.length - 1;
        // <=
        while(top >= 1 && nums[top] <= nums[top - 1])
            top--;
        if(top > 0) {
            int pre = top - 1, index = nums.length - 1, tmp = nums[pre];
            // <=
            while(index >= pre && nums[index] <= nums[pre])
                index--;
            nums[pre] = nums[index];
            nums[index] = tmp;
        }
        Arrays.sort(nums, top, nums.length);
    }
}
