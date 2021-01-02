package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 11:06
 * Description:
 */
public class P26 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int prev = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[prev]) {
                prev++;
                nums[prev] = nums[i];
            }
        }
        return prev + 1;
    }

}
