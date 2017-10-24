package solution400_499;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zjw on 2017/10/24.
 */
public class P421_MaximumXORofTwoNumbersInArray {

    // TLE
    public int findMaximumXOR(int[] nums) {

        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    // solution 2: from leetcode discussion
    public int findMaximumXOR2(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--) {
            // calculate prefix
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num & mask);
            }

            int tmp = max | (1 << i);  // possible maximum xor of two prefix
            for(Integer prefix : set) {
                if(set.contains(prefix ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

}
