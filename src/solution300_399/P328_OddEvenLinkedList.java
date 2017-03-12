package solution300_399;


public class P328_OddEvenLinkedList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null)    return head;
		ListNode odd = new ListNode(0), even = new ListNode(0);
		ListNode l1 = odd, l2 = even;
		boolean is_odd = false;
		while(head != null)
		{
			is_odd = !is_odd;
			if(is_odd)
			{
				l1.next = head;
				l1 = l1.next;
			}
			else{
				l2.next = head;
				l2 = l2.next;
			}
			head = head.next;
		}
		l1.next = even.next;
		l2.next = null;
		return odd.next;
	}
}
