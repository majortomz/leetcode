package solution600_699;

/**
 * Created by zjw on 2017/12/5.
 */
public class P695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int height = grid.length, width = grid[0].length;
        boolean[][] isVisited = new boolean[height][width];
        int max = 0;

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(isVisited[i][j] || grid[i][j] == 0)
                    continue;
                max = Math.max(max, helper(grid, isVisited, i, j));
            }
        }
        return max;
    }

    public int helper(int[][] grid, boolean[][] isVisited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || isVisited[row][col] || grid[row][col] == 0)
            return 0;

        isVisited[row][col] = true;
        int area = 1;
        area += helper(grid, isVisited, row + 1, col);
        area += helper(grid, isVisited, row - 1, col);
        area += helper(grid, isVisited, row, col + 1);
        area += helper(grid, isVisited, row, col - 1);
        return area;
    }

}
