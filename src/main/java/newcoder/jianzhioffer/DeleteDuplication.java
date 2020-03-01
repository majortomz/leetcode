package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/09 21:47
 * Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)    return null;
        ListNode res = new ListNode(pHead.val - 1);
        ListNode pre = res, tail = res;
        while(pHead != null) {
            if(pre.val != pHead.val && (pHead.next == null || pHead.val != pHead.next.val)) {
                tail.next = pHead;
                tail = pHead;
            }
            pre = pHead;
            pHead = pHead.next;
        }
        tail.next = null;
        return res.next;
    }
}
