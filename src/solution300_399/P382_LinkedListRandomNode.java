package solution300_399;

import java.util.Random;

/**
 * Created by zjw on 2018/01/24 9:52
 * Description:
 */
public class P382_LinkedListRandomNode {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    class Solution {

        ListNode head;
        int len = 0;
        Random random = new Random();

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            ListNode curNode = head;
            while(curNode != null) {
                len++;
                curNode = curNode.next;
            }
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int index = random.nextInt(len);
            ListNode curNode = head;
            while(index > 0) {
                index--;
                curNode = curNode.next;
            }
            return curNode.val;
        }
    }

    // from leetcode discussion
    class Solution2 {

        ListNode head;
        Random random;

        public Solution2(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode curNode = head;
            int val = curNode.val;
            for(int i = 1; curNode.next != null; i++) {
                curNode = curNode.next;
                if(random.nextInt(i + 1) == 0) {
                    val = curNode.val;
                }
            }
            return val;
        }

    }

}
