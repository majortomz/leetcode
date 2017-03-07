package solution100_199;

import java.util.ArrayList;

public class P143_ReorderList {

	// ListNode 的定义
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*
	 * Solution1：通过数组记录原来链表的顺序，来进行reorder
	 */
	public void reorderList(ListNode head) {
		// 如果head为Null，则返回
		if(head == null)  return;
		// 遍历链表，将其放到数组中
		ArrayList<ListNode> arr = new ArrayList<ListNode>();
		ListNode newHead = new ListNode(0), curNode = head;
		while(curNode != null)
		{
			arr.add(curNode);
			curNode = curNode.next;
		}
		// 当前节点指向newHead
		curNode = newHead;
		// 同时从前向后，从后向前遍历数组
		for(int i=0, j = arr.size()-1; i<=j; i++, j--)
		{
			curNode.next = arr.get(i);
			curNode = curNode.next;
			if(i < j)
			{
				// 处理 i == j的情况，i==j的话则不插入
				curNode.next = arr.get(j);
				curNode = curNode.next;
			}
		}
		// 将当前节点的next置为空
		curNode.next = null;
		// 将head.next置为newHead.next.next
		head.next = newHead.next.next;
	}
	
	
	/*
	 * Solution 2： 在链表上分为三步，进行reorder
	 */
	public void reorderList2(ListNode head){
		if(head == null)	return;
		ListNode p1 = head, p2 = head;
		ListNode curNode = null;  //记录中心点后面链表反转后的头部
		// Step 1: 找到中心点  1->2->3->4->5 or 1->2->3->4->5->6
		while(p2.next != null && p2.next.next != null)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}
		// Step 2: 从中心点断开，把中心点后面的链表进行反转   1->2->3 5->4 or 1->2->3 6->5->4
		p2 = p1.next;
		p1.next = null;
		while(p2 != null)
		{
			ListNode next = p2.next;
			p2.next = curNode;
			curNode = p2;
			p2 = next;
		}
		// Step 3: 依次插入两个链表  
		p1 = head;
		while(curNode != null)
		{
			ListNode next = p1.next, next2 = curNode.next;
			p1.next = curNode;
			curNode.next = next;
			p1 = next;
			curNode = next2;
		}
	}
}
