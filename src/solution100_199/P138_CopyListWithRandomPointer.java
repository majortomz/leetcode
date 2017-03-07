package solution100_199;

import java.util.HashMap;

public class P138_CopyListWithRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> hMap = new HashMap<>();
		RandomListNode n1 = head;
		RandomListNode newHead = new RandomListNode(0), curNode = newHead;
		while(n1 != null)
		{
			RandomListNode temp = new RandomListNode(n1.label);
			hMap.put(n1, temp);
			curNode.next = temp;
			curNode = curNode.next;
			n1 = n1.next;
		}
		n1 = head;
		curNode = newHead.next;
		while(n1 != null)
		{
			curNode.random = hMap.get(n1.random);
			n1 = n1.next;
			curNode = curNode.next;
		}
		return newHead.next;
	}
}
