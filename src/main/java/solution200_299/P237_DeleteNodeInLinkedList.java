package solution200_299;

public class P237_DeleteNodeInLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/*
	 * 可以通过修改值来达到删除某个node的目的
	 */
	public void deleteNode(ListNode node) {
		if (node == null)
			return;
		ListNode last_n = node;
		while (node.next != null) {
			node.val = node.next.val;
			last_n = node;
			node = node.next;
		}
		last_n.next = null;
	}
}
