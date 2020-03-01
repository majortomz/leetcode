package leetcode_ms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zjw on 2018/08/05 22:37
 * Description:
 */
public class P23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for(ListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }

        ListNode res = new ListNode(0);
        ListNode prev = res;

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            prev.next = node;
            if(node.next != null) {
                queue.add(node.next);
            }
            prev = node;
        }

        return res.next;
    }

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) {
                return null;
            }

            int k = lists.length;
            while(k > 1) {
                for(int i = 0; i < k; i += 2) {
                    if(i + 1 == k) {
                        lists[i / 2] = lists[i];
                    } else {
                        lists[i / 2] = merge(lists[i], lists[i + 1]);
                    }
                }
                k = k / 2 + (k % 2);
            }
            return lists[0];
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            ListNode prev = res;
            while(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            if(l1 == null) {
                prev.next = l2;
            }

            if(l2 == null){
                prev.next = l1;
            }

            return res.next;
        }

    }

}
