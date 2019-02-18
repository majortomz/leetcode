package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 21:49
 * Description: Reverse Nodes in k-Group
 */
public class P25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);

        ListNode prev = res;

        while(head != null) {

            int i = 1;
            ListNode tmpPrev = head, cur = head.next;
            head.next = null;
            while(cur != null && i < k) {
                ListNode tmp = cur.next;
                cur.next = tmpPrev;
                tmpPrev = cur;
                cur = tmp;
                i++;
            }

            if(i >= k) {
                prev.next = tmpPrev;
                prev = head;
                head = cur;
            } else {
                cur = tmpPrev.next;
                tmpPrev.next = null;
                while(cur != null) {
                    ListNode tmp = cur.next;
                    cur.next = tmpPrev;
                    tmpPrev = cur;
                    cur = tmp;
                }
                prev.next = tmpPrev;
                break;
            }

        }

        return res.next;
    }

}
