package solution200_299;

import java.util.Arrays;

/**
 * Created by zjw on 2017/6/10 15:36.
 */
public class P238_ProductOfArray {

    // [0,0]
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pro = 1;
        // from left to right
        for(int i = 0 ; i < nums.length; i++) {
            res[i] += pro;
            pro *= nums[i];
        }
        pro = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= pro;
            pro *= nums[i];
        }
        return res;
    }
}
