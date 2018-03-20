package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/09 21:36
 * Description:
 */
public class EntryNodeLoop {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead, fast = pHead;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (pHead != slow) {
                    pHead = pHead.next;
                    slow = slow.next;
                }
                return pHead;
            }
        }
        return null;
    }

}
