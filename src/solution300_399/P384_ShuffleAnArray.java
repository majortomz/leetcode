package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2018/01/24 10:38
 * Description:
 */
public class P384_ShuffleAnArray {

    class Solution {
        int[] origin;
        Random random;

        public Solution(int[] nums) {
            this.origin = nums;
            this.random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < origin.length; i++) {
                list.add(i);
            }
            int[] shuffle = new int[origin.length];
            int n = origin.length;
            for(int i = 0; i < n; i++) {
                int index = random.nextInt(list.size());
                shuffle[i] = origin[list.get(index)];
                list.remove(index);
            }
            return shuffle;
        }

        public int[] shuffle2() {
            int[] shuffle = Arrays.copyOf(origin, origin.length);
            for(int i = 0; i < shuffle.length; i++) {
                int k = random.nextInt(i + 1);
                int tmp = shuffle[k];
                shuffle[k] = shuffle[i];
                shuffle[i] = tmp;
            }
            return shuffle;
        }
    }

}
