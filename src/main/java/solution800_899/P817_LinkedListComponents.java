package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/04/16 9:22
 * Description:
 */
public class P817_LinkedListComponents {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer> map = new HashMap<>();
        int prev = -1;
        while (head != null) {
            map.put(head.val, prev);
            prev = head.val;
            head = head.next;
        }

        int count = G.length;
        Set<Integer> set = new HashSet<>();
        for(int g : G) {
            set.add(g);
        }
        for(int g : G) {
            if(set.contains(map.get(g))) {
                count--;
            }
        }
        return count;
    }

}
