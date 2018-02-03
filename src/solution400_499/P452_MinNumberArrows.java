package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2018/02/01 16:15
 * Description:
 */
public class P452_MinNumberArrows {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        int count = 0, rt = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (i != 0 && points[i][0] <= rt) {
                rt = Math.min(points[i][1], rt);
            } else {
                rt = points[i][1];
                count++;
            }
        }
        return count;
    }

}
