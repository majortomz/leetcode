package solution;

public class P86_PartitionList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode partition(ListNode head, int x) {
		ListNode curNode = head, pre = null, newHead = new ListNode(0), start;
		newHead.next = head;
		start = newHead;
		// 找到要替换的第一个
		while(curNode != null && curNode.val < x)
		{
			start = curNode;
			curNode = curNode.next;
		}
		pre = curNode;
		while(curNode != null)
		{
			if(curNode.val >= x)
			{
				pre = curNode;
				curNode = curNode.next;
				continue;
			}
			pre.next = curNode.next;
			curNode.next = start.next;
			start.next = curNode;
			start = curNode;
			curNode = pre.next;
		}
		return newHead.next;
	}
}
