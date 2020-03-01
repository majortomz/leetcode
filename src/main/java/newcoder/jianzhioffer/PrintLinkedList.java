package newcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by zjw on 2018/03/01 15:43
 * Description: 从尾到头打印链表
 */
public class PrintLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        while(listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

}
