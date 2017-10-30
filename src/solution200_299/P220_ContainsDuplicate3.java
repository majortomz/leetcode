package solution200_299;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by zjw on 2017/10/28.
 */
public class P220_ContainsDuplicate3 {

    // -1 - (2^31 - 1)
    // TLE , complexity( k * N)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 1; i < nums.length; i++) {
            for(int j = Math.max(i - k, 0); j < i; j++) {
                if(Math.abs((long)nums[i] - nums[j]) <= t)
                    return true;
            }
        }
        return false;
    }

    // O(n * logk)
    public boolean containsNearbyAlmotstDuplicate2(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i]);
            Long ceil = set.ceiling((long)nums[i]);

            if((floor != null && nums[i] - floor <= t) || (ceil != null && ceil - nums[i] <= t))
                return true;
            set.add((long)nums[i]);
            if(i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    // O(n)
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if(nums.length == 0 || k < 1 || t < 0)
            return false;

        Map<Long, Long> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            long mappedValue = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = mappedValue / ((long)t + 1);
            if(map.containsKey(bucket) || (map.containsKey(bucket - 1) && mappedValue - map.get(bucket - 1) <= t)
                    || map.containsKey(bucket + 1) && map.get(bucket + 1)  - mappedValue <= t)
                return true;
            if(map.entrySet().size() >= k) {
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, mappedValue);
        }
        return false;
    }

}
