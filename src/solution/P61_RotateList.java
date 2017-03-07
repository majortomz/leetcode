package solution;

public class P61_RotateList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		int len = length(head);
		k = k % len;
		if (k == 0)
			return head;
		ListNode curNode = head, newHead = null;
		// len记录当前节点之后还有几个节点
		len--;
		while (len > k) {
			curNode = curNode.next;
			len--;
		}
		newHead = curNode.next;
		curNode.next = null;
		curNode = newHead;
		while (curNode.next != null)
			curNode = curNode.next;
		curNode.next = head;
		return newHead;
	}

	public int length(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
