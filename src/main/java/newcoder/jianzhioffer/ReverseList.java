package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 14:37
 * Description:
 */
public class ReverseList {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if(head == null)    return null;
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
