package leetcode_ms;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/07 8:59
 * Description: Minimum Number of Arrows to Burst Balloonss
 */
public class P452 {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        int n = points.length;
        Arrays.sort(points, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        int prev = points[0][1], res = 1;
        for(int i = 1; i < n; i++) {
            if(points[i][0] > prev) {
                prev = points[i][1];
                res++;
            } else {
                prev = Math.min(prev, points[i][1]);
            }
        }
        return res;
    }
}
