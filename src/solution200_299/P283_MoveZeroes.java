package solution200_299;

/**
 * Created by zjw on 2017/5/17.
 */
public class P283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int num = -1;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] != 0)
            {
                num++;
                int tmp = nums[i];
                nums[i] = nums[num];
                nums[num] = tmp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int num = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[num] = nums[i];
                num++;
            }
        }
        for(int i=num; i<nums.length; i++)
            nums[i] = 0;
    }
}
