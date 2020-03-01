package leetcode_ms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2018/07/16 10:18
 * Description:
 */
public class P138 {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    // use hash map...
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = head, res = new RandomListNode(-1);
        RandomListNode resCur = res;
        while(cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            map.put(cur, node);
            resCur.next = node;
            resCur = resCur.next;

            cur = cur.next;
        }

        cur = head;
        resCur = res.next;
        while(cur != null) {
            resCur.random = map.get(cur.random);
            cur = cur.next;
            resCur = resCur.next;
        }

        return res.next;
    }

    // O(1) space, from leetcode discussion
    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null) {
            return null;
        }

        RandomListNode cur = head, curCp = null;

        // A -> B   =>   A -> A_cp -> B -> B_cp
        while(cur != null) {
            curCp = new RandomListNode(cur.label);
            curCp.next = cur.next;
            cur.next = curCp;
            cur = curCp.next;
        }

        cur = head;
        while(cur != null) {
            curCp = cur.next;
            curCp.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // detach,   A -> A_cp -> B -> B_cp   =>    A_cp -> B_cp  A -> B
        cur = head;
        RandomListNode headCp = head.next;
        curCp = headCp;
        while(cur != null) {
            cur.next = cur.next.next;
            curCp.next = curCp.next == null ? null : curCp.next.next;

            cur = cur.next;
            curCp = curCp.next;
        }

        return headCp;
    }

}
