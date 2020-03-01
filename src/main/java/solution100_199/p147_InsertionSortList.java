package solution100_199;

import java.util.ArrayList;

public class p147_InsertionSortList {
	
	// ListNode 的定义
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode insertionSortList(ListNode head) {
		ListNode curNode = head;
		ArrayList<ListNode> arr = new ArrayList<ListNode>();
		while(curNode != null)
		{
			arr.add(curNode);
			int value = curNode.val, i;
			for(i = arr.size()-2; i>=0; i--){
				if(value < arr.get(i).val)
					arr.get(i+1).val = arr.get(i).val;
				else
					break;
			}
			arr.get(i+1).val = value;
			curNode = curNode.next;
		}
		return head;
	}
	
	public ListNode insertionSortList2(ListNode head) {
		ListNode newHead = new ListNode(0), curNode, pre;
		while(head != null)
		{
			pre = head;
			head = head.next;
			curNode = newHead;
			while(curNode.next != null && pre.val > curNode.next.val )
			{
				curNode = curNode.next;
			}
			pre.next = curNode.next;
			curNode.next = pre;
		}
		return newHead.next;
	}
}
