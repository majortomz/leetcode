package solution800_899;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zjw on 2018/05/27 9:53
 * Description:
 */
public class P841_KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) {
            return true;
        }
        int n = rooms.size(), count = rooms.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        count -= 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: rooms.get(cur)) {
                if(visited[next]) {
                    continue;
                }
                count--;
                visited[next] = true;
                queue.offer(next);
            }
        }
        return count == 0;
    }

}
