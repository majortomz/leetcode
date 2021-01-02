package solution300_399;

/**
 *
 * Created by zjw on 2017/11/23.
 */
public class P306_AdditiveNumber {

    /**
         "112358"
         "199100199"
         "123"
         "199111992"
         "121474836472147483648"
     */
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3)
            return false;
        long[] nums = new long[num.length()];
        char[] chars = num.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }

        long maxLen = nums.length / 2, first = 0, second;
        for(int i = 0; i < maxLen; i++) {
            first = first * 10 + nums[i];
            second = 0;
            int end = i + (nums.length - i) / 2;
            for(int j = i + 1; j <= end; j++) {
                second = second * 10 + nums[j];
                if(helper(nums, j + 1, first, second))
                    return true;
                if(second == 0)
                    break;
            }
            if(first == 0)
                break;
        }
        return false;
    }

    public boolean helper(long[] nums, int start, long first, long second) {
        if(start >= nums.length)
            return false;
        long sum = first + second, third = 0;
        for(int i = start; i < nums.length; i++) {
            third = third * 10 + nums[i];
            if(first + second == third) {
                return (i == nums.length - 1) || helper(nums, i + 1, second, third);
            } else if(third == 0 || first + second < third) {
                break;
            }
        }
        return false;
    }

}
