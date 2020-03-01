package solution300_399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zjw on 2017/6/21 16:25.
 */
public class P350_IntersectionOfArray2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num: nums2) {
            int count = map.getOrDefault(num, 0);
            if(map.containsKey(num) && count > 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

}
