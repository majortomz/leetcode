package solution100_199;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by zjw on 2017/5/23.
 */
public class P169_MajortiyElement {

    public int majorityElement(int[] nums) {
        if(nums == null || nums.length <= 0)    return 0;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int max = nums[0];
        map.put(max, 1);
        for(int i=1; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > map.get(max))
                max = nums[i];
        }
        return max;
    }

    // from leetcode discussion
    public int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                count = 1;
                major = nums[i];
            }
            else if(nums[i] == major) {
                count++;
            }
            else {
                count--;
            }
        }
        return major;
    }

}
