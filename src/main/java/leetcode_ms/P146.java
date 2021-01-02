package leetcode_ms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2018/08/04 17:12
 * Description:
 */
public class P146 {
    class LRUCache {

        int[] values;
        Map<Integer, Integer> map = new HashMap<>();

        public LRUCache(int capacity) {

        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            } else {
                return values[map.get(key)];
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {}
        }
    }
}
