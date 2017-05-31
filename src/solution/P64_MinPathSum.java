package solution;

import java.util.Arrays;

/**
 * Created by zjw on 2017/5/31.
 */
public class P64_MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length, width = grid[0].length;
        int[] mat = new int[width];
        Arrays.fill(mat, Integer.MAX_VALUE);
        mat[0] = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(j == 0)
                    mat[j] = mat[j] + grid[i][j];
                else
                    mat[j] = Math.min(mat[j], mat[j-1]) + grid[i][j];
            }
        }
        return mat[width-1];
    }

}
