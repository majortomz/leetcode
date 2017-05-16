package solution200_299;

import java.util.Arrays;

/**
 * Created by zjw on 2017/5/16.
 */
public class P217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
}
