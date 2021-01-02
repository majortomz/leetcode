package solution700_799;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2018/07/05 16:34
 * Description:
 */
public class P754_ReachANumber {

    // no doubt, TLE
    public int reachNumber(int target) {
        int step = 1;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int cur = queue.poll();
                int nextA = cur + step, nextB = cur - step;
                if(nextA == target || nextB == target) {
                    return step;
                }
                queue.add(nextA);
                queue.add(nextB);
                size--;
            }
            step++;
        }
        return 0;
    }

    // from leetcode discussion
    public int reachNumber2(int target) {
        target = Math.abs(target);
        int k = 0;
        while(target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

}
