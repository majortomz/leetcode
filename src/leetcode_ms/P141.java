package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 9:24
 * Description:
 */
public class P141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

}
