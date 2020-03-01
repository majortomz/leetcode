package solution100_199;

import java.util.HashSet;

public class P141_LinkedListCyle {

	// ListNode 的定义
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*
	 * 使用HashSet来记录已经出现过的ListNode object
	 */
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> hSet = new HashSet<>();
		while (head != null) {
			if (hSet.contains(head))
				return true;
			hSet.add(head);
			head = head.next;
		}
		return false;
	}

	/*
	 * 第二种方法：
	 */
	public boolean hasCycle2(ListNode head) {
		while(head != null)
		{
			// 如果当前head所指向的对象和head.next指向的对象相同，则出现环路
			if(head.next == head)
				return true;
			// 将当前head所指对象的next指向自身，同时将head指向下一个对象
			ListNode next_node = head.next;
			head.next = head;
			head = next_node;
		}
		return false;
	}
}
