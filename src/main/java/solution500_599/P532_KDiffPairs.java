package solution500_599;

import java.util.Arrays;

/**
 * Created by zjw on 2017/5/17.
 */
public class P532_KDiffPairs {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length; i++)
        {
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i += 1;
            }
            if(i - 1 >= 0 && k == 0 && nums[i] - nums[i-1] == k)
                res++;
            int j = i + 1;
            while(j < nums.length)
            {
                int sub = nums[j] - nums[i];
                if(sub < k)
                {
                    j++;
                    continue;
                }
                res += (sub == k? 1:0);
                break;
            }
        }
        return res;
    }

}
