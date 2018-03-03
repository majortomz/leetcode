package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 14:20
 * Description: 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        len = len - k + 1;
        cur = head;
        if(len <= 0) return null;
        while(len > 1) {
            cur = cur.next;
            len--;
        }
        return cur;
    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        if(k <= 0)  return null;
        ListNode p1 = head, p2 = head;
        while(p2 != null && k > 1) {
            p2 = p2.next;
            k--;
        }
        if(p2 == null)  return null;
        while(p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

}
