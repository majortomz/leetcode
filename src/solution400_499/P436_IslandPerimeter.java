package solution400_499;

/**
 * Created by zjw on 2017/6/16 15:42.
 */
public class P436_IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int[][] go = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int p = 0, height = grid.length, width = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                for(int k = 0; k < go.length; k++) {
                    int ni = i + go[k][0], nj = j + go[k][1];
                    if(ni < 0 || ni >= height || nj < 0 || nj >= width || grid[ni][nj] == 0)
                        p++;
                }
            }
        }
        return p;
    }

}
