package solution200_299;

/**
 * Created by zjw on 2017/10/17.
 */
public class P260_SingleNumber3 {

    // from leetcode discussion
    public int[] singleNumber(int[] nums) {
        int c = 0;
        int[] res = new int[2];
        // step 1: get a^b
        for(int num : nums)
            c ^= num;
        c &= ~(c - 1);  // get last significant bit
        for(int num : nums) {
            if((num & c) == 0) {
                res[0] ^= num;
            }
            else {
                res[1] ^= num;
            }
        }
        return res;
    }

}
