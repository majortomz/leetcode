package solution100_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zjw on 2017/9/25.
 */
public class P130_SorroundedRegions {

    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[][] go = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int height, width;

    // TLE
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)  return;
        height = board.length;
        width = board[0].length;
        boolean[][] isVisited = new boolean[height][width];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(board[i][j] == 'X' || isVisited[i][j]) continue;

                List<Point> region = new ArrayList<>();
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j));
                int ni, nj;
                boolean isLeagal = true;

                while(!queue.isEmpty()) {
                    Point curPoint = queue.poll();
                    region.add(curPoint);
                    isVisited[curPoint.x][curPoint.y] = true;

                    for(int k = 0; k < go.length; k++) {
                        ni = curPoint.x + go[k][0];
                        nj = curPoint.y + go[k][1];
                        if(ni < 0 || ni >= height || nj < 0 || nj >= width) {
                            isLeagal = false;
                        } else {
                            if(board[ni][nj] == 'X' || isVisited[ni][nj])     continue;
                            queue.add(new Point(ni, nj));
                        }
                    }
                }
                if(!isLeagal) {
                    for(Point p : region)
                        board[p.x][p.y] = 'X';
                }
            }
        }
    }

    public void solve2(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)  return;
        height = board.length;
        width = board[0].length;
        boolean[][] isVisited = new boolean[height][width];
        Queue<Point> queue = new LinkedList<>();

        for(int i = 0; i < height; i++) {
            if(board[i][0] != 'X')
                queue.add(new Point(i, 0));
            if(board[i][width-1] != 'X')
                queue.add((new Point(i, width - 1)));
        }

        for(int j = 1; j < width - 1; j++) {
            if(board[0][j] != 'X')
                queue.add(new Point(0, j));
            if(board[height-1][j] != 'X')
                queue.add(new Point(height - 1, j));
        }

        System.out.println(queue.size());

        while(!queue.isEmpty()) {
            Point curPoint = queue.poll();
            isVisited[curPoint.x][curPoint.y] = true;

            int ni, nj;

            for(int k = 0; k < go.length; k++) {
                ni = curPoint.x + go[k][0];
                nj = curPoint.y + go[k][1];
                if(ni < 0 || ni >= height || nj < 0 || nj >= width || board[ni][nj] == 'X' || isVisited[ni][nj]) {
                    continue;
                }
                queue.add(new Point(ni, nj));
            }
        }

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(board[i][j] == 'X' || isVisited[i][j])
                    continue;
                board[i][j] = 'X';
            }
        }
    }

}
