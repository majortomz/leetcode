package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 21:44
 * Description:  Search in Rotated Sorted Array
 */
public class P33 {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }


        // find smallest element's position
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // determine search boundary
        int min = low;
        if(min == 0 || target < nums[0]) {
            low = min;
            high = nums.length - 1;
        } else {
            low = 0;
            high = min - 1;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

}
