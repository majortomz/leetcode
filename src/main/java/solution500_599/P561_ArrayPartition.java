package solution500_599;

import java.util.Arrays;

/**
 * Created by zjw on 2017/5/19.
 */
public class P561_ArrayPartition {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i+=2)
            sum += nums[i];
        return sum;
    }

    // Solution2: Leetcode discussion, using hash array
    // Because n is a positive integer, which is in the range of [1, 10000].
    // All the integers in the array will be in the range of [-10000, 10000].
    public int arrayPairSum2(int[] nums) {
        int hash[] = new int[20001], p = 0, sum = 0;
        for(int i=0; i<nums.length; i++)
            hash[nums[i] + 10000] += 1;
        for(int i=0; i<hash.length; i++)
        {
            while(hash[i] != 0)
            {
                p++;
                if(p % 2 == 1)  sum += (i - 10000);
                hash[i]--;
            }
        }
        return sum;
    }
}
