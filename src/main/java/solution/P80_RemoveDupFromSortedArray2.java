package solution;

/**
 * Created by zjw on 2017/5/27.
 */
public class P80_RemoveDupFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int last = 1, count = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[i-1])
                count = 0;
            count++;
            if(count <= 2)
            {
                nums[last++] = nums[i];
            }
        }
        return last;
    }

}
