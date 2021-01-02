package solution400_499;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjw on 2017/6/26 10:45.
 */
public class P599_MinIndexSumOfLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                if(i + map.get(list2[i]) > min)  continue;
                if(i + map.get(list2[i]) < min) {
                    min = i + map.get(list2[i]);
                    list = new ArrayList<>();
                }
                list.add(list2[i]);
            }
        }
        String[] res = new String[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
}
