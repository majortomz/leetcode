package solution;

public class P21_MergeTwoSortedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		ListNode head = null, curNode = null;
		if (l1.val < l2.val) {
			head = curNode = l1;
			l1 = l1.next;
		} else {
			head = curNode = l2;
			l2 = l2.next;
		}
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curNode.next = l1;
				l1 = l1.next;
			} else {
				curNode.next = l2;
				l2 = l2.next;
			}
			curNode = curNode.next;
		}
		if (l1 == null) {
			curNode.next = l2;
		} else {
			curNode.next = l1;
		}
		return head;
	}
}
