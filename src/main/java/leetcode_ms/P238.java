package leetcode_ms;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/03 20:07
 * Description:
 */
public class P238 {

    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        if(nums.length == 1) {
            return new int[]{0};
        }

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        int multi = 1;
        for(int i = 1; i < n; i++) {
            multi *= nums[i - 1];
            res[i] = multi;
        }

        multi = 1;
        for(int i = n - 2; i >= 0; i--) {
            multi *= nums[i + 1];
            res[i] *= multi;
        }

        return res;
    }

}
