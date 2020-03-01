package solution800_899;

/**
 * Created by zjw on 2018/03/25 9:48
 * Description:
 */
public class P807_MaxIncreaseToCity {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int[] cols = new int[width], rows = new int[height];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                cols[j] = Math.max(cols[j], grid[i][j]);
                rows[i] = Math.max(rows[i], grid[i][j]);
            }
        }

        int sum = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int target = Math.min(rows[i], cols[j]);
                if(target > grid[i][j]) {
                    sum += target - grid[i][j];
                }
            }
        }
        return sum;
    }

}
