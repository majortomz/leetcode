package solution700_799;

import java.util.Arrays;

/**
 * Created by zjw on 2018/07/14 16:12
 * Description:
 */
public class P757_SetIntersectionSizeAtLeastTwo {

    // from leetcode discussion, greedy method
    public int intersectionSizeTwo(int[][] intervals) {
        // sort, [s, e], s ascending, e descending
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));

        int res = 0;

        int[] todos = new int[intervals.length];
        Arrays.fill(todos, 2);

        for (int i = intervals.length - 1; i >= 0; i--) {
            int s = intervals[i][0], e = intervals[i][1];
            int m = todos[i];
            for (int j = s; j < s + m; j++) {
                for (int k = 0; k < i; k++) {
                    if (todos[k] > 0 && j <= intervals[k][1]) {
                        todos[k]--;
                    }
                }
                res++;
            }
        }
        return res;
    }

}
