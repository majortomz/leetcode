package test;

import java.util.*;

/**
 * Created by zjw on 2018/09/06 20:29
 * Description:
 */
public class MT_P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 1; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            if(!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            if(!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }
            map.get(x).add(y);
            map.get(y).add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        int depth = 0;
        queue.add(1);
        visited.add(1);
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for(int i = 1; i <= size; i++) {
                int cur = queue.poll();
                for(int next : map.get(cur)) {
                    if(!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        depth -= 1;
        System.out.println(2 * (n - 1) - depth);

    }

}
