package solution;

/**
 * Created by zjw on 2017/5/31.
 */
public class P63_UniquePaths2 {

    // [[1]]
    // [[0],[1]]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int height = obstacleGrid.length, width = obstacleGrid[0].length;
        int[] mat = new int[width];
        mat[0] = 1 - obstacleGrid[0][0];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(obstacleGrid[i][j] == 1)
                    mat[j] = 0;
                else if(j > 0)
                    mat[j] += mat[j-1];
            }
        }
        return mat[width - 1];
    }
}
