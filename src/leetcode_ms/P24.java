package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 22:27
 * Description:
 */
public class P24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode pHead = new ListNode(0);
        ListNode prev = pHead;
        while(head != null && head.next != null) {
            ListNode next = head.next.next;

            prev.next = head.next;
            prev.next.next = head;
            prev = head;

            head = next;
        }
        prev.next = head;

        return pHead.next;

    }

}
