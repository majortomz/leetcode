package solution100_199;

import java.util.HashSet;
import java.util.List;

public class P142_LinkedListCycle2 {
	// ListNode 的定义
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head){
		HashSet<ListNode> set = new HashSet<ListNode>();
		while(head != null)
		{
			if(set.contains(head))
				return head;
			set.add(head);
			head = head.next;
		}
		return null;
	}
	
	
	// 参考https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation
	// 
	public ListNode detectCycle2(ListNode head){
		if(head == null)	return null;
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
			{
				while(head != slow)
				{
					head = head.next;
					slow = slow.next;
				}
				return head;
			}
		}
		return null;
	}
}
