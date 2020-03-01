package solution;

/**
 * Created by zjw on 2017/6/1.
 */
public class P55_JumpGame {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)    return false;
        int stepRes = 1;
        for(int i = 0; i < nums.length; i++) {
            stepRes--;
            if(stepRes < 0) return false;
            stepRes = Math.max(stepRes, nums[i]);
        }
        return true;
    }

    // from leetcode discussion
    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0)    return false;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
