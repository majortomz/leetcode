package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2018/01/26 14:11
 * Description:
 */
public class P398_RandomPickIndex {

    // can also use recursive sampling
    class Solution {

        Map<Integer, List<Integer>> map;
        Random random;

        public Solution(int[] nums) {
            random = new Random();
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }

}
