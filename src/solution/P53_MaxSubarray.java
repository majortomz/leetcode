package solution;

/**
 * Created by zjw on 2017/5/19.
 */
public class P53_MaxSubarray {
    // Solution1:
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if(sum < 0)     sum = 0;
        }
        return max;
    }

    // Solution2: divide and conquer as requested. WA...
    public int maxSubArray2(int[] nums) {
        int[] res =  helper(nums, 0, nums.length - 1);
        return res[0];
    }

    public int[] helper(int[] nums, int start, int end) {
//        System.out.println(start + " " + end);
        if(start == end) {
            int res[] = {nums[start], start, end};
            return res;
        }
        int mid = (start + end) / 2, sum = 0;
        int left[], right[];
        left = helper(nums, start, mid);
        right = helper(nums, mid + 1, end);
        if(left[0] <= 0 || right[0] <= 0)
        {
            if(left[0] > right[0])  return left;
            else    return right;
        }
        for(int i=left[2] + 1; i< right[1]; i++)
        {
            sum += nums[i];
        }
        if(sum + left[0] + right[0] > left[0] + right[0])
        {
            int res[] = {sum + left[0] + right[0], left[1], right[2]};
            return res;
        }
        else {
            if(left[0] > right[0])  return left;
            else    return right;
        }
    }

    public static void main(String[] args) {
        P53_MaxSubarray ms = new P53_MaxSubarray();
        int[] test = {-2, 1,-3,4,-1,2,1,-5,4};
        ms.maxSubArray2(test);
    }
}
