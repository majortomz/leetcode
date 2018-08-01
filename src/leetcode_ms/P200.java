package leetcode_ms;

/**
 * Created by zjw on 2018/07/18 10:21
 * Description:
 */
public class P200 {


    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    helper(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        helper(grid, visited, i - 1, j);
        helper(grid, visited, i + 1, j);
        helper(grid, visited, i, j - 1);
        helper(grid, visited, i, j + 1);
    }

}
