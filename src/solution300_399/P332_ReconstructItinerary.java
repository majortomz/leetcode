package solution300_399;

import java.util.*;

/**
 *
 * Created by zjw on 2017/12/5.
 */
public class P332_ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if(tickets == null || tickets.length == 0)  return result;

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Map<String, Integer>> visited = new HashMap<>();

        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) {
                visited.put(ticket[0], new HashMap<>());
                map.put(ticket[0], new ArrayList<>());
            }
            visited.get(ticket[0]).put(ticket[1], visited.get(ticket[0]).getOrDefault(ticket[1], 0) + 1 );
            map.get(ticket[0]).add(ticket[1]);
        }

        // sort
        for(List<String> list : map.values()) {
            list.sort((x, y) -> x.compareTo(y));
        }

        dfs(map, visited, result, "JFK", tickets.length + 1);
        return result;
    }

    public boolean dfs(Map<String, List<String>> map, Map<String, Map<String, Integer>> visited, List<String> path, String from, int count) {
        path.add(from);
        List<String> nexts = map.getOrDefault(from, new ArrayList<>());
        for(int i = 0; i < nexts.size(); i++) {
            String next = nexts.get(i);
            if(visited.get(from).getOrDefault(next, 0) <= 0)    continue;
            visited.get(from).put(next, visited.get(from).get(next) - 1);
            if(dfs(map, visited, path, nexts.get(i), count)) {
                return true;
            }
            visited.get(from).put(next, visited.get(from).get(next) + 1);
        }
        if(path.size() == count) {
            return true;
        } else {
            path.remove(path.size() - 1);
            return false;
        }
    }


    class Solution2 {
        public List<String> findItinerary(String[][] tickets) {
            List<String> result = new ArrayList<>();
            if(tickets == null || tickets.length == 0)  return result;

            Map<String, PriorityQueue<String>> map = new HashMap<>();
            for(String[] ticket : tickets) {
                map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
            }

            dfs(map, result, "JFK");
            return result;
        }

        public void dfs(Map<String, PriorityQueue<String>> map, List<String> result, String from) {
            PriorityQueue<String> queue = map.get(from);
            while(queue != null && queue.size() > 0) {
                String next = queue.poll();
                dfs(map, result, next);
            }
            result.add(0, from);
        }
    }

}

