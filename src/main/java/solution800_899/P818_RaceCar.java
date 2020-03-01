package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/04/16 11:03
 * Description:
 */
public class P818_RaceCar {

    public int racecar(int target) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 1});
        int step = 0;
        visited.add("0#1");
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 1; i <= size; i++) {
                int[] cur = queue.poll();
                // A
                int next = cur[0] + cur[1], speed = cur[1] * 2;
                if(next == target)  return step + 1;
                if(cur[0] < 2 * target && next > 0 && !visited.contains(next + "#" + speed)) {
                    visited.add(next + "#" + speed);
                    queue.add(new int[]{next, speed});
                }
                // R
                next = cur[0];
                speed = cur[1] > 0 ? -1 : 1;
                if(next > 0 && !visited.contains(next + "#" + speed)) {
                    visited.add(next + "#" + speed);
                    queue.add(new int[]{next, speed});
                }
            }
            step++;
        }
        return step;
    }

}
