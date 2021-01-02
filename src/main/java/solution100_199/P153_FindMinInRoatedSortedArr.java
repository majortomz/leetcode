package solution100_199;

/**
 * Created by zjw on 2017/5/31.
 */
public class P153_FindMinInRoatedSortedArr {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int lt = 0, rt = nums.length - 1;
        if(nums[lt] < nums[rt]) return nums[lt];
        for(int i = 1; i <= rt; i++) {
            if(nums[i] < nums[i-1])
                return nums[i];
        }
        return nums[rt];
    }

    public int findMin2(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int lt = 0, rt = nums.length - 1, mid;
        while(lt <= rt && nums[lt] > nums[rt]) {
            mid = (lt + rt) / 2;
            if(nums[mid] > nums[rt])
                lt = mid + 1;
            else
                rt = mid;  // rt  = mid; not rt = mid - 1....
        }
        return nums[lt];
    }
}
