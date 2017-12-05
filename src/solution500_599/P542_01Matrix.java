package solution500_599;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2017/12/5.
 */
public class P542_01Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return matrix;

        int[][] go = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int height = matrix.length, width = matrix[0].length;
        boolean[][] isVisited = new boolean[height][width];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) {
                    isVisited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir : go) {
                int ni = cur[0] + dir[0], nj = cur[1] + dir[1];
                if(ni < 0 || ni >= height || nj < 0 || nj >= width || isVisited[ni][nj])
                    continue;
                isVisited[ni][nj] = true;
                matrix[ni][nj] = matrix[cur[0]][cur[1]] + 1;
                queue.add(new int[]{ni, nj});
            }
        }
        return matrix;
    }

}
