package leetcode_ms;

/**
 * Created by zjw on 2018/07/18 15:26
 * Description:
 */
public class P445 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1), len2 = getLength(l2);

        ListNode head = helper(l1, len1, l2, len2);
        if(head != null && head.val >= 10) {
            ListNode node = new ListNode(head.val / 10);
            head.val %= 10;
            node.next = head;
            head = node;
        }
        return head;
    }

    private ListNode helper(ListNode l1, int len1, ListNode l2, int len2) {
        if(l1 == null || l2 == null) {
            return null;
        }

        int val;
        ListNode next;
        if(len1 != len2) {
            val = len1 > len2 ? l1.val: l2.val;
            next = len1 > len2 ? helper(l1.next, len1 - 1, l2, len2) : helper(l1, len1, l2.next, len2 - 1);
        } else {
            val = l1.val + l2.val;
            next = helper(l1.next, len1 - 1, l2.next, len2 - 1);
        }

        // handle carry
        if(next != null) {
            val += next.val / 10;
            next.val %= 10;
        }
        ListNode cur = new ListNode(val);
        cur.next = next;
        return cur;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
