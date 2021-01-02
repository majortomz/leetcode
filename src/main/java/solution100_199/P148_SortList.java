package solution100_199;

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
		slow = slow.next;
		ListNode left = mergesortList(start, slow);
		ListNode right = mergesortList(slow, end);
		ListNode result = new ListNode(0), cur = result;
		while (left != null && right != null) {
			if (left.val > right.val) {
				cur.next = right;
				right = right.next;
			} else {
				cur.next = left;
				left = left.next;
			}
			cur = cur.next;
		}
		if(left == null){
			cur.next = right;
		}
		if(right == null){
			cur.next = left;
		}
		return result.next;
	}

	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = { 4, 19, 14, 5, -3, 1, 8, 5, 11, 15 };
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
