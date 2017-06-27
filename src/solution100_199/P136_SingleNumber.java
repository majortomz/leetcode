package solution100_199;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zjw on 2017/6/26 16:01.
 */
public class P136_SingleNumber {

    // Basic Solution
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums) {
            if(set.contains(val))
                set.remove(val);
            else
                set.add(val);
        }
        Integer[] res = new Integer[set.size()];
        set.toArray(res);
        return res[0];
    }

    // Bit manipulation, linear time, no extra space
    public int singleNumber2(int[] nums) {
        int res = 0;
        for(int val : nums) {
            res ^= val;
        }
        return res;
    }

}
