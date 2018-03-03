package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 16:23
 * Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class ListMerge {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;

        while(list1 != null || list2 != null) {
            if(list1 == null || (list2 != null && list2.val < list1.val)) {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            }
        }
        return root.next;
    }
}
