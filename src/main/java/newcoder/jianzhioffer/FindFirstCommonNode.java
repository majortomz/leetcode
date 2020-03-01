package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 10:41
 * Description: 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)    return null;
        ListNode cur1 = pHead1, cur2 = pHead2;
        while(cur1 != cur2) {
            cur1 = cur1 == null ? pHead2 : cur1.next;
            cur2 = cur2 == null ? pHead1 : cur2.next;
        }
        return cur1;
    }

}
