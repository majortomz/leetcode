package solution500_599;

import java.util.HashMap;

/**
 * Created by zjw on 2017/6/20 16:56.
 */
public class P594_LongestHarmSubseq {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Integer key: map.keySet()) {
            if(map.containsKey(key + 1)) {
                int tmp = map.get(key) + map.get(key + 1);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }
}
