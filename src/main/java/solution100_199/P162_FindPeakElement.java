package solution100_199;

/**
 * Created by zjw on 2017/6/14 16:49.
 */
public class P162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1])
                return i-1;
        }
        return nums.length - 1;
    }

}
