package solution;

public class P19_RemoveNthNodeFromEndofList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		cur.next = head;
		int len = length(head);
		len = len - n;
		while (len >= 1) {
			len--;
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return newHead.next;
	}

	public int length(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	// Solution2: according to leetcode discussion
	public ListNode remvoeNthFromEnd2(ListNode head, int n) {
		ListNode newHead = new ListNode(0);
		ListNode slow = newHead, fast = newHead;
		newHead.next = head;
		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return newHead.next;
	}
}
