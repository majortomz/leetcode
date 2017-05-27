package solution;

/**
 * Created by zjw on 2017/5/26.
 */
public class P33_SearchInRotatedSortedArr {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)   return -1;
        if(nums[0] == target)   return 0;
        int i = 1;
        while(i < nums.length)
        {
            if(nums[i] == target)
                return i;
            else if(nums[i] >= nums[i-1])
                i++;
            else
                break;
        }
        int lt = i, rt = nums.length - 1, mid;
        while(lt <= rt)
        {
            mid = (lt + rt) / 2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                rt = mid - 1;
            else
                lt = mid + 1;
        }
        return -1;
    }

}
