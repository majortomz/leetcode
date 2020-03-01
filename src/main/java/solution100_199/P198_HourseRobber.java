package solution100_199;

/**
 * Created by zjw on 2017/5/18.
 */
public class P198_HourseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int a1 = 0, a2 = 0, a3 = 0;
        for(int i = 0; i<nums.length; i++)
        {
            int at1 = a1, at2 = a2, at3 = a3;
            a1 = Math.max(at2, at3) + nums[i];
            a2 = at1;
            a3 = at2;
        }
        return Math.max(Math.max(a1, a2), a3);
    }


    // from leet code discussion
    public int rob2(int[] num) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for(int i=0; i<num.length; i++) {
            int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

}
