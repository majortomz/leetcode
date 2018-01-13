package solution400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/01/12 15:33
 * Description:
 */
public class P417_PAWaterFlow {

    int[][] go = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pm = new boolean[m][n], am = new boolean[m][n];

        dfs(matrix, pm, new int[]{0, 0}, 0, 0);
        dfs(matrix, am, new int[]{m-1, n-1}, m - 1, n - 1);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pm[i][j] && am[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, boolean[][] pm, int[] origin, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || pm[i][j]) {
            return;
        }

        pm[i][j] = true;

        for(int[] step : go) {
            int ni = i + step[0], nj = j + step[1];
            if(ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[0].length) {
                continue;
            }
            if(ni == origin[0] || nj == origin[1] || matrix[ni][nj] >= matrix[i][j]) {
                dfs(matrix, pm, origin, ni, nj);
            }
        }
    }


}
