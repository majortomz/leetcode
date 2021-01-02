package solution800_899;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by zjw on 2018/07/15 9:56
 * Description:
 */
public class P870_AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[A.length];
        for(int i = B.length - 1; i >= 0; i--) {
            Integer key = map.higherKey(B[i]) == null ? map.firstKey() : map.higherKey(B[i]);
            if(map.get(key) == 1) {
                map.remove(key);
            } else {
                map.put(key, map.get(key) - 1);
            }
            res[i] = key;
        }
        return res;
    }

}
