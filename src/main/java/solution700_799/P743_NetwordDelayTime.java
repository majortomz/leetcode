package solution700_799;

import java.util.*;

/**
 * Created by zjw on 2018/01/06 19:04
 * Description:
 */
public class P743_NetwordDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        // init
        int[] dis = new int[N + 1];
        Map<Integer, List<int[]>> map = new HashMap<>();
        Arrays.fill(dis, -1);
        dis[K] = 0;
        for(int[] time : times) {
            if(!map.containsKey(time[0])) {
                map.put(time[0], new LinkedList<>());
            }
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++) {
            set.add(i);
        }
        set.remove(K);
        int next = K;
        for(int i = 1; i < N; i++) {
            // update dis
            for(int[] edge : map.getOrDefault(next, new ArrayList<>())) {
                dis[edge[0]] = dis[edge[0]] == -1 ? dis[next] + edge[1] : Math.min(dis[edge[0]], dis[next] + edge[1]);
            }
            // get next
            int min = Integer.MAX_VALUE;
            for(int node : set) {
                if(dis[node] != -1 && dis[node] < min) {
                    min = dis[node];
                    next = node;
                }
            }
            set.remove(next);
        }

        int max = -1;
        for(int i = 1; i <= N; i++) {
            if(dis[i] == -1)  return -1;
            max = Math.max(dis[i], max);
        }
        return max;
    }

}
