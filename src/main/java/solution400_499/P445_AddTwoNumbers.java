package solution400_499;

public class P445_AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		int len1 = length(l1), len2 = length(l2), c = 0;
		while (len1 > len2) {
			ListNode node = new ListNode(l1.val);
			node.next = result.next;
			result.next = node;
			l1 = l1.next;
			len1--;
		}
		while (len2 > len1) {
			ListNode node = new ListNode(l2.val);
			node.next = result.next;
			result.next = node;
			l2 = l2.next;
			len2--;
		}
		while (l1 != null && l2 != null) {
			ListNode node;
			node = new ListNode(l1.val + l2.val);
			node.next = result.next;
			result.next = node;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode pre = null, curNode = result.next, next;
		while (curNode != null) {
			c += curNode.val;
			curNode.val = c % 10;
			c /= 10;
			next = curNode.next;
			curNode.next = pre;
			pre = curNode;
			curNode = next;
		}
		if(c != 0)
		{
			ListNode node = new ListNode(c);
			node.next = pre;
			pre = node;
		}
		return pre;
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
