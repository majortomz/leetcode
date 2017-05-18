package solution200_299;

/**
 * Created by zjw on 2017/5/18.
 */
public class P213_HouseRobber2 {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        int rob = 0, norob = 0;
        int r1, r2;
        for(int i=0; i<nums.length - 1; i++)
        {
            int currob = norob + nums[i];
            norob = Math.max(norob, rob);
            rob = currob;
        }
        r1 = Math.max(rob, norob);
        rob = 0;
        norob = 0;
        for(int i=1; i < nums.length; i++)
        {
            int currob = norob + nums[i];
            norob = Math.max(norob, rob);
            rob = currob;
        }
        r2 = Math.max(rob, norob);
        return Math.max(r1, r2);
    }
}
