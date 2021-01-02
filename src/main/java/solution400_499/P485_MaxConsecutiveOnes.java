package solution400_499;

/**
 * Created by zjw on 2017/5/18.
 */
public class P485_MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == 0)
                continue;
            int tmp = 0;
            for(int j=i; j<nums.length && nums[j] == 1; j++)
                tmp++;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
