package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/04/08 10:23
 * Description:
 */
public class P815_BusRoutes {

    // TLE...
    // TODO
    public int numBusesToDestination(int[][] routes, int S, int T) {
        // init graph
        Map<Integer, Integer> map = new HashMap<>();

        int[][] graph = new int[2501][2501];
        for (int[] line : graph) {
            Arrays.fill(line, -1);
        }

        int count = 0;
        for (int[] route : routes) {
            for (int i = route.length - 2; i >= 0; i--) {
                if (!map.containsKey(route[i])) map.put(route[i], count++);
                int m = map.get(route[i]);
                graph[m][m] = 0;
                for (int j = i + 1; j < route.length; j++) {
                    if (!map.containsKey(route[j])) map.put(route[j], count++);
                    graph[map.get(route[j])][map.get(route[j])] = 0;
                    graph[m][map.get(route[j])] = 1;
                    graph[map.get(route[j])][m] = 1;
                }
            }
        }

        // 计算换乘的公交车数目
        if (!map.containsKey(S) || !map.containsKey(T)) {
            return -1;
        }
        int m = map.get(S), n = map.get(T);
        if (graph[m][n] == 1) return 0;  // int the same bus line

        int[] dis = new int[2501];
        Arrays.fill(dis, -1);
        Set<Integer> setB = new HashSet<>();
        // init
        for (int i = 0; i < count; i++) {
            if (i != m) setB.add(i);
        }
        int prev = m;
        dis[m] = 0;
        for (int i = 1; i < count; i++) {
            // update
            for (int j : setB) {
                if (graph[prev][j] == -1) continue;
                dis[j] = dis[j] == -1 ? dis[prev] + graph[prev][j] : Math.min(dis[j], dis[prev] + graph[prev][j]);
            }
            // select
            int min = Integer.MAX_VALUE, index = -1;
            for (int j : setB) {
                if (dis[j] != -1 && dis[j] < min) {
                    min = dis[j];
                    index = j;
                }
            }
            if (index == -1 || index == n) break;
            prev = index;
            setB.remove(index);
        }

        for (int i = 0; i < count; i++) {
            System.out.print(dis[i] + " ");
        }
        return dis[n];
    }

    class Solution2 {
        // BFS
        public int numBusesToDestination(int[][] routes, int S, int T) {

            if(S == T)  return 0;
            Set<Integer> visited = new HashSet<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            // init
            for(int i = 0; i < routes.length; i++) {
                for(int j = 0; j < routes[i].length; j++) {
                    List<Integer> list = map.getOrDefault(routes[i][j], new ArrayList<>());
                    list.add(i);
                    map.put(routes[i][j], list);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(S);
            int ret = 0;
            while(!queue.isEmpty()) {
                int len = queue.size();
                ret++;
                for(int i = 1; i <= len; i++) {
                    int cur = queue.poll();
                    for(int bus : map.get(cur)) {
                        if(visited.contains(bus))   continue;
                        visited.add(bus);
                        for(int j = 0; j < routes[bus].length; j++) {
                            if(routes[bus][j] == T)   return ret;
                            queue.add(routes[bus][j]);
                        }
                    }
                }
            }
            return -1;
        }
    }

}
