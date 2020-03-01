package solution800_899;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2018/06/04 9:18
 * Description:
 */
public class P847_ShortestPathVisitingAllNodes {

    // bfs
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // [[cover, head], ]
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[1 << n][n];

        for(int[] row : dist) {
            Arrays.fill(row, n * n);
        }
        for(int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            queue.offer(new int[]{1 << i, i});
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int d = dist[cur[0]][cur[1]];
            if(cur[0] == (1 << n)  - 1) {
                return d;
            }

            for(int next : graph[cur[1]]) {
                int cover2 = cur[0] | (1 << next);
                if(d + 1 < dist[cover2][next]) {
                    queue.offer(new int[]{cover2, next});
                    dist[cover2][next] = d + 1;
                }
            }
        }

        return -1;
    }

}
