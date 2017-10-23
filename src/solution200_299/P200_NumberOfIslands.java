package solution200_299;

/**
 * Created by zjw on 2017/10/17.
 */
public class P200_NumberOfIslands {

    int[][] go = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int height, width;

    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0)    return 0;
        height = grid.length;
        width = grid[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(grid[i][j] == '0' || grid[i][j] == '#')
                    continue;
                count++;
                helper(grid, i, j);
            }
        }
        return count;
    }

    public void helper(char[][] grid, int i, int j) {
        if(i < 0 || i >= height || j < 0 || j >= width || grid[i][j] == '0' || grid[i][j] == '#')
            return;

        grid[i][j] = '#';
        for(int[] dir : go) {
            helper(grid, i + dir[0], j + dir[1]);
        }
    }

}
