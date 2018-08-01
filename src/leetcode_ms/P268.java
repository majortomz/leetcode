package leetcode_ms;

/**
 * Created by zjw on 2018/07/19 10:20
 * Description:
 */
public class P268 {

    public int missingNumber(int[] nums) {
        if(nums == null) {
            return -1;
        }

        int sum = 0;
        for(int num: nums) {
            sum += num;
        }

        return (nums.length + 1) * nums.length / 2 - sum;
    }

}
