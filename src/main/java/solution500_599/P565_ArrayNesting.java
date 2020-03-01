package solution500_599;

/**
 * Created by zjw on 2017/5/31.
 */
public class P565_ArrayNesting {

    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0) continue;
            int k = i, count = 0;
            while(nums[k] > 0)
            {
                count++;
                int tmp = k;
                k = nums[k];
                nums[tmp] = -1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
