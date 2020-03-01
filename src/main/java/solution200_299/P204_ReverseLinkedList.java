package solution200_299;

import solution200_299.P203_RemoveLinkedListElements.ListNode;

public class P204_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null, next;
		while(head != null)
		{
			// 保存下一个遍历节点的引用
			next = head.next;
			// 修改当前遍历节点的next
			head.next = pre;
			// 修改pre为当前节点
			pre = head;
			// 将head指向下一个遍历节点
			head = next;
		}
		return pre;
	}
}
