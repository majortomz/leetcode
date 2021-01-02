package solution200_299;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zjw on 2017/5/16.
 */
public class P219_ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                if(i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // from leetcode discussion, more concise and consumes less time
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(i > k)  set.remove(nums[i - k - 1]);
            if(!set.add(nums[i]))   return true;
        }
        return false;
    }
}
