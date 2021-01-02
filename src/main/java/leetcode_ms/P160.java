package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 10:37
 * Description:
 */
public class P160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        if(headA == null || headB == null) {
            return null;
        }

        while(true) {
            if(l1 == l2) {
                return l1;
            }

            l1 = l1 == null ? headB: l1.next;
            l2 = l2 == null ? headA: l2.next;
        }
    }

}
