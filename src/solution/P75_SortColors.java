package solution;

/**
 * Created by zjw on 2017/5/27.
 */
public class P75_SortColors {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length <=1) return;
        int zPos = 0, tPos = nums.length - 1;
        for(int i = 0; i <= tPos; i++)
        {
            if(nums[i] == 0)
                nums[zPos++] = 0;
            else if(nums[i] == 2)
            {
                while(tPos > i && nums[tPos] == 2)
                    tPos--;
                if(nums[tPos] == 0)
                    nums[zPos++] = 0;
                nums[tPos--] = 2;
            }
        }
        for(int i = zPos; i <= tPos; i++)
            nums[i] = 1;
    }
}
