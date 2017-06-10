package solution;

import java.util.Arrays;

/**
 * Created by zjw on 2017/6/9 11:31.
 */
public class P16_3SumClosest {

    // Solution 1: O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        int delta = Integer.MAX_VALUE;
        int res = target;
        if(nums == null || nums.length <=2) return res;
        Arrays.sort(nums);
        int last = nums.length - 3;
        for(int i = 0; i <= last; i++) {
            if(i > 0 && nums[i] == nums[i-1])   continue;
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int tmp = nums[left] + nums[right] + nums[i];
                if(tmp == target) {
                    return target;
                }
                else if (tmp > target)
                    right--;
                else
                    left++;
                if(Math.abs(tmp - target) < delta) {
                    delta = Math.abs(tmp - target);
                    res = tmp;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
