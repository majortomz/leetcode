package solution500_599;

/**
 * Created by zjw on 2018/03/13 15:23
 * Description:
 */
public class P540_SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length < 3)   return -1;
        int lt = 0, rt = nums.length - 1;
        while(lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if(mid > 0 && nums[mid] == nums[mid - 1]) {
                if(mid % 2 == 1)    lt = mid + 1;
                else rt = mid - 2;
            } else if(mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                if(mid % 2 == 0)    lt = mid + 2;
                else    rt = mid - 1;
            } else {
                return nums[mid];
            }
        }
        return nums[rt];
    }

    public int singleNonDuplicate2(int[] nums) {
        if(nums == null || nums.length < 3)  return -1;
        int lt = 0, rt = nums.length - 1;
        while(lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if(mid % 2 == 1)    mid = mid - 1;
            if(nums[mid] == nums[mid + 1])  lt = mid + 2;
            else rt = mid - 1;
        }
        return nums[lt];
    }

}
