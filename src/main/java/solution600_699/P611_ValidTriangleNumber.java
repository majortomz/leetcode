package solution600_699;

import java.util.Arrays;

/**
 * Created by zjw on 2017/6/14.
 */
public class P611_ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        Arrays.sort(nums);
        int lastA = nums.length - 3, lastB = nums.length - 2, count = 0;
        for(int i = 0; i <= lastA; i++) {
            for(int j = i + 1; j <= lastB; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] > nums[k])
                        count++;
                    else
                        break;
                }
            }
        }
        return count;
    }

    //From leetcode discussion
    public int triangleNumber2(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        Arrays.sort(nums);
        int head = 2, count = 0;
        for(int i = nums.length - 1; i >= head; i--) {
            int left = 0, right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                }
                else
                    left++;
            }
        }
        return count;
    }
}
