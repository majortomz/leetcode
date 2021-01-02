package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2017/6/2 11:04.
 */
public class P380_InsertDeleteGetRamdom {
    public class RandomizedSet {

        Map<Integer, Integer> map;
        ArrayList<Integer> arr;
        Random random;


        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.map = new HashMap<>();
            this.arr = new ArrayList<>();
            this.random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
           if(this.map.containsKey(val))    return false;
           this.map.put(val, this.arr.size());
           arr.add(val);
           return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!this.map.containsKey(val)) return false;
            int index = map.get(val), last = this.arr.size() - 1;
            if(index < last) {
                this.arr.set(index, arr.get(last));
                this.map.put(arr.get(last), index);
            }
            arr.remove(last);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = random.nextInt(arr.size());
            return arr.get(index);
        }
    }

}
