package solution;

public class P82_RemoveDuplicatesFromSortedList2 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(0), curNode = newHead, pre = head;
		boolean dup = false;
		head = head.next;
		while (head != null) {
			if (dup == true && head.val != pre.val) {
				pre = head;
				dup = false;
			} else if (dup == false && head.val == pre.val) {
				dup = true;
			} else if (dup == false && head.val != pre.val) {
				curNode.next = pre;
				curNode = curNode.next;
				pre = head;
			}
			head = head.next;
		}
		if(dup == false)
		{
			curNode.next = pre;
			curNode = curNode.next;
		}
		curNode.next = null;
		return newHead.next;
	}
}
