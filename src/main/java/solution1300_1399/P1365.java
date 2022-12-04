package solution1300_1399;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Description:
 *
 * @author lanling.zjw date: 2020/03/07 18:15
 */
public class P1365 {

    // How Many Numbers Are Smaller Than the Current Number

    public int[] smallerNumbersThanCurrent(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        for (int i = 0; i < nums.length; i++) {
            res[i] = binarySearch(copy, nums[i]);
        }

        return res;
    }

    private int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
