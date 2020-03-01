package solution;

/**
 * Created by zjw on 2017/5/27.
 */
public class P81_SearchInRoatedSortedArray2 {

    // [1,3,1,1,1]  3
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return false;
        if(nums[0] == target)   return true;
        int lt = 0, rt = nums.length - 1, mid;
        while(lt + 1 < nums.length && nums[lt] == nums[lt + 1])
            lt++;
        lt += 1;
        while(lt <= rt) {
            mid = (lt + rt) / 2;
            if(target == nums[mid])
                return true;
            if(nums[lt] <= nums[mid])
            {
                if(target < nums[lt] || target > nums[mid])
                    lt = mid + 1;
                else
                    rt = mid - 1;
            }
            else {
                if(target > nums[mid] && target < nums[lt])
                    lt = mid + 1;
                else
                    rt = mid - 1;
            }
        }
        return false;
    }

}
