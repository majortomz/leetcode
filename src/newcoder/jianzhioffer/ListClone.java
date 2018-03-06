package newcoder.jianzhioffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by zjw on 2018/03/03 17:02
 * Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ListClone {

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode root = new RandomListNode(0);
        RandomListNode prev = root;
        map.put(null, null);
        while(pHead != null) {
            if(map.containsKey(pHead))
                prev.next = map.get(pHead);
            else {
                prev.next = new RandomListNode(pHead.label);
                map.put(pHead, prev.next);
            }
            if(map.containsKey(pHead.random)) {
                prev.next.random = map.get(pHead.random);
            } else {
                prev.next.random = new RandomListNode(pHead.random.label);
                map.put(pHead.random, prev.next.random);
            }
            System.out.println(prev.next.label + " " + prev.next.random.label);
            prev = prev.next;
            pHead = pHead.next;
        }
        return root.next;
    }

    private void test() {
        RandomListNode r1 = new RandomListNode(1), r2 = new RandomListNode(2), r3 = new RandomListNode(3);
        r1.next = r2; r1.random = r3;
        r2.next = r3; r2.random = r1;
        r3.random = r2;
        Clone(r1);
    }

    public static void main(String[] args) {
        ListClone listClone = new ListClone();
        listClone.test();
    }

}
