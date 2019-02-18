package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 13:55
 * Description: Find Peak Element
 */
public class P162 {

    // O(n)
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        for(int i = 0; i < nums.length; i++) {
            if((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    public int findPeakElement3(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

}
