package solution;

/**
 * Created by zjw on 2017/6/3 16:22.
 */
public class P34_SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        if(nums == null || nums.length == 0)    return result;
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target)
                break;
            else if(target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        if(left > right)  return result;
        left = mid - 1;
        while(left >= 0 && nums[left] == nums[mid])
            left--;
        right = mid + 1;
        while(right < nums.length && nums[right] == nums[mid])
            right++;
        result[0] = left + 1;
        result[1] = right - 1;
        return result;
    }

}
