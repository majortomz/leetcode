package solution400_499;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2017/6/26 11:07.
 */
public class P447_NumberOfBoomerranges {

    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for(int i= 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                int dis = x*x + y*y;
                for(int k = j + 1; k < points.length; k++) {
                    x = points[i][0] - points[k][0]; y = points[i][1] - points[k][1];
                    int dis2 = x*x + y*y;
                    x = points[j][0] - points[k][0]; y = points[j][1] - points[k][1];
                    int dis3 = x*x + y*y;
                    if(dis2 == dis3)
                        count += 2;
                    if(dis == dis2)
                        count += 2;
                    if(dis == dis3)
                        count += 2;
                }
            }
        }
        return count;
    }

    public int numberOfBoomerangs2(int[][] points) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j)  continue;
                int dis = getDis(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for(Integer val: map.values()) {
                count += val * (val - 1);
            }
            map.clear();
        }
        return count;
    }

    public int getDis(int a[], int b[]) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x*x + y*y;
    }

}
