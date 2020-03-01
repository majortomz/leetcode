package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/07/10 9:32
 * Description: Shortest Path to Get All Keys
 */
public class P865_ShortestPath {

    Set<Integer> visited = new HashSet<>();
    char[][] board;
    private int INDEX_I = 0x1F << 12, INDEX_J = 0x1F << 7;
    private int LOCKS = 0;

    private int[][] go = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        board = new char[m][n];

        int startCode = 0;
        for (int i = 0; i < m; i++) {
            board[i] = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '@') {
                    startCode = encode(i, j, 0);
                } else if ('a' <= board[i][j] && board[i][j] <= 'f') {
                    LOCKS |= (1 << board[i][j] - 'a');
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        visited.add(startCode);
        queue.add(startCode);
        int size = queue.size(), step = 0;
        while (!queue.isEmpty()) {
            if (size == 0) {
                size = queue.size();
                step++;
            }
            size--;

            int code = queue.poll();
            int i = (code & INDEX_I) >> 12, j = (code & INDEX_J) >> 7, state = code & LOCKS;
            for (int[] next : go) {
                int ni = i + next[0], nj = j + next[1];

                if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length || board[ni][nj] == '#' ||
                        'A' <= board[ni][nj] && board[ni][nj] <= 'F' && (state & (1 << board[ni][nj] - 'A')) == 0) {
                    continue;
                }

                int nextState = state;
                if ('a' <= board[ni][nj] && board[ni][nj] <= 'f') {
                    nextState = state | (1 << board[ni][nj] - 'a');
                    if (nextState == LOCKS) {
                        return step + 1;
                    }
                }
                int nextCode = encode(ni, nj, nextState);
                if (!visited.contains(nextCode)) {
                    visited.add(nextCode);
                    queue.offer(nextCode);
                }
            }

        }

        return -1;
    }

    private int encode(int i, int j, int state) {
        return (i << 12) | (j << 7) | state;
    }

    public static void main(String[] args) {
        P865_ShortestPath pp = new P865_ShortestPath();
        System.out.println(pp.shortestPathAllKeys(new String[]{"@.a.#", "###.#", "b.A.B"}));
    }

}
