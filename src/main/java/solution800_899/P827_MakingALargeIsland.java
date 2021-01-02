package solution800_899;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zjw on 2018/04/30 9:53
 * Description:
 */
public class P827_MakingALargeIsland {
    int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length, largest = 0;
        int[][] islands = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        List<Integer> areas = new ArrayList<>();

        // calculate areas of islands
        int index = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                index++;
                int count = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    count++;
                    islands[cur[0]][cur[1]] = index;
                    for(int[] nei : neighbors) {
                        int ni = cur[0] + nei[0], nj = cur[1] + nei[1];
                        if(ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj] && grid[ni][nj] == 1) {
                            visited[ni][nj] = true;
                            queue.add(new int[]{ni, nj});
                        }
                    }
                }
                largest = Math.max(count, largest);
                areas.add(count);
            }
        }

        // get most
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    continue;
                }
                int area = 1;
                List<Integer> isSet = new ArrayList<>();
                for(int[] nei : neighbors) {
                    int ni = i + nei[0], nj = j + nei[1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n && islands[ni][nj] != 0) {
                        int island = islands[ni][nj];
                        if(!isSet.contains(island)) {
                            isSet.add(island);
                            area += areas.get(island - 1);
                        }
                    }
                }
                largest = Math.max(area, largest);
            }
        }
        return largest;
    }

}
