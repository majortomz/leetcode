package solution100_199;

/**
 * Created by zjw on 2017/5/24.
 */
public class P152_MaxProductSubarray {

    // 考虑 负负得正， 0的情况
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, pro = 1, count = 0;
        int index[] = new int[nums.length], store[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0) {
                count = 0;
                store[i] = 0;
            }
            else if(nums[i] > 0) {
                store[i] = nums[i] * (i > 0 && store[i-1] > 0 ? store[i-1]: 1);
            }
            else if(count == 0) {
                count++;
                store[i] = nums[i];
            }
            else {
                // 当前负数个数为 count + 1
                count++;
                index[count - 1] = i;
                int pos = index[count % 2], tmpPro = 1;
                for(int k = pos; k <=i; k++)
                    tmpPro *= nums[k];
                if(pos > 0 && store[pos-1] > 0)
                    tmpPro *= store[pos-1];
                store[i] = tmpPro;
            }
            max = Math.max(max, store[i]);
        }
        return max;
    }

    // from leetcode discussion
    public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int maxPre = nums[0], minPre = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tmp = maxPre;
            maxPre = Math.max(Math.max(maxPre*nums[i], minPre*nums[i]), nums[i]);
            minPre = Math.min(Math.min(tmp * nums[i], minPre * nums[i]), nums[i]);
            max = Math.max(maxPre, max);
        }
        return max;
    }

}
