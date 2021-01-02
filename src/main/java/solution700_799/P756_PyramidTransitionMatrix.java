package solution700_799;

import java.util.*;

/**
 * Created by zjw on 2018/07/14 10:04
 * Description:
 */
public class P756_PyramidTransitionMatrix {

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> tripleMap = new HashMap<>();
        // pre-process allowed
        for(String triple: allowed) {
            String base = triple.substring(0, 2), top = triple.substring(2);
            if(!tripleMap.containsKey(base)) {
                tripleMap.put(base, new ArrayList<>());
            }
            tripleMap.get(base).add(top);
        }

        Deque<String> left = new LinkedList<>();
        for(int i = 0; i < bottom.length(); i++) {
            left.addLast(bottom.substring(i, i + 1));
        }
        return helper(left, new LinkedList<>(), tripleMap);
    }

    public static boolean helper(Deque<String> left, Deque<String> right, Map<String, List<String>> tripleMap) {
        if(right.size() == 0) {
            if(left.size() == 1) {
                return true;
            }
            Deque<String> tmp = right;
            right = left;
            left = tmp;
        } else if(right.size() == 1) {
            right.removeFirst();
            return helper(left, right, tripleMap);
        }

        String first = right.pollFirst(), key = first + right.getFirst();
        if(!tripleMap.containsKey(key)) {
            return false;
        }
        for(String next : tripleMap.get(key)) {
            Deque<String> nl = new LinkedList<>(left), nr = new LinkedList<>(right);
            nl.addLast(next);
            if(helper(nl, nr, tripleMap)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        pyramidTransition("ABC", Arrays.asList("ABD","BCE","DEF","FFF"));
    }
}
