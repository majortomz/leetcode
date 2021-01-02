package solution700_799;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by zjw on 2018/05/14 10:43
 * Description:
 */
public class P785_IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {

        int m = graph.length;
        // 0 未染色， 染色值为-1 1
        int[] colored = new int[m];

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            if(colored[i] == 0) {
                queue.offer(i);
                colored[i] = 1;
                while(!queue.isEmpty()) {
                    int id = queue.poll();
                    for(int j : graph[id]) {
                        if(colored[j] == 0) {
                            colored[j] = -colored[id];
                            queue.add(j);
                        } else if(colored[id] == colored[j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // dfs version of isBipartite
    public boolean isBipartite2(int[][] graph) {
        int m = graph.length;

        // using two set to mark color
        Set<Integer> cur = new HashSet<>(), next = new HashSet<>();

        for(int i = 0; i < m; i++) {
            if(!cur.contains(i) && !next.contains(i)) {
                if(!dfs(graph, i, cur, next)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int i, Set<Integer> cur, Set<Integer> next) {

        cur.add(i);
        for(int j : graph[i]) {
            if(!next.contains(j)) {
                if(cur.contains(j)) {
                    return false;
                }
                if(!dfs(graph, j, next, cur)) {
                    return false;
                }
            }

        }
        return true;
    }

}
