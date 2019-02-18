package leetcode_ms;

/**
 * Created by zjw on 2018/08/03 20:22
 * Description:
 */
public class P237 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
