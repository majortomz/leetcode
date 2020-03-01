package solution800_899;

/**
 * Created by zjw on 2018/05/27 9:33
 * Description:
 */
public class P840_MagicSquareInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        if(grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        int count = 0;
        for(int i = m - 1; i >= 2; i--) {
            for(int j = n - 1; j >= 2; j--) {
                if(isMagic(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isMagic(int[][] grid, int x, int y) {
        boolean[] exists = new boolean[10];
        int[] cols = new int[3];
        int preSum = -1;
        for(int i = x - 2; i <= x; i++) {
            int curRow = 0;
            for(int j = y - 2; j <= y; j++) {
                int cur = grid[i][j];
                if(cur > 9 || cur < 1 || exists[cur]) {
                    return false;
                }
                exists[cur] = true;
                curRow += cur;
                cols[y - j] += cur;
            }
            if(preSum != -1 && preSum != curRow) {
                return false;
            }
            preSum = curRow;
        }

        for(int col : cols) {
            if(preSum != col) {
                return false;
            }
        }

        return preSum == grid[x][y] + grid[x - 1][y - 1] + grid[x - 2][y - 2] &&
                preSum == grid[x][y - 2] + grid[x - 1][y - 1] + grid[x - 2][y];
    }

}
