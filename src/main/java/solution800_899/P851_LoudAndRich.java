package solution800_899;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zjw on 2018/06/10 9:59
 * Description:
 */
public class P851_LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> map = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int counts[] = new int[n];
        int res[] = new int[n];

        for(int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
            res[i] = i;
        }
        for(int[] larger: richer) {
            map.get(larger[0]).add(larger[1]);
            counts[larger[1]]++;
        }
        for(int i = 0; i < n; i++) {
            if(counts[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: map.get(cur)) {
                if(quiet[res[cur]] < quiet[res[next]]) {
                    res[next] = res[cur];
                }
                counts[next]--;
                if(counts[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return res;
    }

}
