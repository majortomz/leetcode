package solution800_899;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zjw on 2018/06/10 10:34
 * Description:
 */
public class P850_RectangleArea2 {

    private static final int MOD = 1_000_000_007;

    public int rectangleArea(int[][] rectangles) {

        Set<Integer> xSet = new TreeSet<>(), ySet = new TreeSet<>();
        for(int[] rec: rectangles) {
            xSet.add(rec[0]);
            xSet.add(rec[2]);
            ySet.add(rec[1]);
            ySet.add(rec[3]);
        }

        int[] memX = new int[xSet.size()], memY = new int[ySet.size()];
        int lenX = 0, lenY = 0;
        for(int x : xSet) {
            memX[lenX++] = x;
        }
        for(int y: ySet) {
            memY[lenY++] = y;
        }

        Map<Integer, Integer> xMap = new HashMap<>(), yMap = new HashMap<>();
        for(int i = 0; i < memX.length; i++) {
            xMap.put(memX[i], i);
        }
        for(int j = 0; j < memY.length; j++) {
            yMap.put(memY[j], j);
        }

        boolean[][] visited = new boolean[ySet.size()][xSet.size()];

        for(int[] rec: rectangles) {
            for(int i = yMap.get(rec[1]); i < yMap.get(rec[3]); i++) {
                for(int j = xMap.get(rec[0]); j < xMap.get(rec[2]); j++) {
                    visited[i][j] = true;
                }
            }
        }

        long area = 0;
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                if(visited[i][j]) {
                    area += (long)(memY[i] - memY[i + 1]) * (memX[j] - memX[j + 1]);
                }
            }
        }


        return (int)(area % MOD);

    }

}
