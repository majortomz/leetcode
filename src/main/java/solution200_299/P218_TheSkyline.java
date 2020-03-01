package solution200_299;

import java.util.*;

/**
 * Created by zjw on 2018/06/22 10:46
 * Description:
 */
public class P218_TheSkyline {

    // use priority queue, from leetcode discussion
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int[] build: buildings) {
            height.add(new int[]{build[0], -build[2]});   // 用高度的负值来表示左上角
            height.add(new int[]{build[1], build[2]});    // 右上角
        }

        height.sort((a, b) -> (a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]));

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(0);
        int prev = 0;

        for(int[] h: height) {
            if(h[1] < 0) {
                queue.offer(h[1]);
            } else {
                queue.remove(-h[1]);
            }

            int cur = queue.peek();
            if(cur != prev) {
                result.add(new int[]{h[0], -cur});
                prev = cur;
            }
        }
        return result;
    }

}
