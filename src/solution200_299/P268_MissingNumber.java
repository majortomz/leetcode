package solution200_299;

/**
 * Created by zjw on 2017/5/23.
 */
public class P268_MissingNumber {
    public int missingNumber(int[] nums) {
        long sum = nums.length * (nums.length + 1) / 2;
        for(int i = 0; i < nums.length; i++)
            sum -= nums[i];
        return (int)sum;
    }
}
