package solution100_199;

/**
 * Created by zjw on 2017/10/13.
 */
public class P137_SingleNumber2 {

    // Solution 1 from leetcode discussion
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int num : nums) {
            int ta = (~a&b&num) |(a&~b&~num);
            b = (~a&~b&num) | (~a&b&~num);
            a = ta;
        }
        return a|b;
    }

    // Solution 2 from leetcode discussion
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int num : nums) {
                if(((num >> i) & 1) == 1) {
                    sum += 1;
                    sum %= 3;
                }
            }
            ans |= (sum << i);
        }
        return ans;
    }
}
