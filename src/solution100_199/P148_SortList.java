package solution100_199;

import java.awt.RenderingHints;

public class P148_SortList {
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		return mergesortList(head, null);
	}

	public ListNode mergesortList(ListNode start, ListNode end) {
		if (start.next == end) {
			start.next = null;
			return start;
		}
		ListNode slow = start, fast = start;
		while (fast.next != end && fast.next.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode left = mergesortList(start, slow);
		ListNode right = mergesortList(slow, end);
		ListNode result = new ListNode(0), cur = result;
		while (left != null || right != null) {
			if (left == null || (right != null && left.val > right.val)) {
				cur.next = right;
				right = right.next;
			}
			else if (right == null || (left != null && right.val > left.val)) {
				cur.next = left;
				left = left.next;
			} 
			cur = cur.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 4, 5 };
		P148_SortList ps = new P148_SortList();
		ListNode head = ps.new ListNode(test[0]), curNode;
		curNode = head;
		for (int i = 1; i < test.length; i++) {
			ListNode next = ps.new ListNode(test[i]);
			System.out.println(test[i]);
			curNode.next = next;
			curNode = next;
		}
		ps.sortList(head);
	}
}
