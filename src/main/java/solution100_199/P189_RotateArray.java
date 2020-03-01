package solution100_199;

import java.util.Arrays;

/**
 * Created by zjw on 2017/5/19.
 */
public class P189_RotateArray {

    // TLE
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return;
        k = k % nums.length;
        for (int i = 1; i <= k; i++)
        {
            int tmp = nums[nums.length - 1];
            for (int j=nums.length - 1; j >= 1; j--)
            {
                nums[j] = nums[j-1];
            }
            nums[0] = tmp;
        }
    }

    // Solution 2
    public void rotate2(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return;
        int[] copy = Arrays.copyOf(nums, nums.length);
        k %= nums.length;
        for(int i=0; i<k; i++)
            nums[i] = copy[nums.length - (k - i)];
        for(int i = nums.length-k-1; i>=0; i--)
            nums[i + k] = copy[i];
    }

    // Solution 3 From leetcode discussion, using reverse function
    public void rotate3(int [] nums, int k) {
        if(nums == null || nums.length < 2) return;
        k %= nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length -1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
