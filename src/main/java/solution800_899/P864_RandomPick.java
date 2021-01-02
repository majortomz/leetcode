package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/07/04 15:47
 * Description:
 */
public class P864_RandomPick {
    class Solution {

        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        int n;

        public Solution(int N, int[] blacklist) {
            n = N - blacklist.length;

            Set<Integer> setA = new HashSet<>(), setB = new HashSet<>();
            for(int num: blacklist) {
                if(num >= n) {
                    setA.add(num);
                } else {
                    setB.add(num);
                }
            }

            int k = n;
            for(int num : setB) {
                while(setA.contains(k)) {
                    k++;
                }
                map.put(num, k);
                k++;
            }
        }

        public int pick() {
            int index = random.nextInt(n);
            return map.getOrDefault(index, index);
        }

    }

}
