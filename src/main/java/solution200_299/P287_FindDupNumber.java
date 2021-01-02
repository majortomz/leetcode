package solution200_299;

/**
 * Created by zjw on 2017/6/9.
 */
public class P287_FindDupNumber {

    // From LeetCode Discussion
    public int findDuplicate(int[] nums) {
        return 0;
    }

    public int findDuplciate2(int[] nums) {
        int min = 0, max = nums.length - 1;
        while(min <= max) {
            int mid = (min + max) / 2, count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid)
                    count++;
            }
            if(count > mid)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return min;
    }

}
