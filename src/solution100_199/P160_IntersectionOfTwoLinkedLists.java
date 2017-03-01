package solution100_199;

import java.util.HashSet;
import java.util.Set;

public class P160_IntersectionOfTwoLinkedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	//solution 1:使用hash
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
            return null;
		Set<ListNode> nodes = new HashSet<>();
		while(headA!= null)
		{
			nodes.add(headA);
			headA = headA.next;
		}
		while(headB != null)
		{
			if(nodes.contains(headB))
				return headB;
			headB = headB.next;
		}
		return null;
	}
	
	//solution2 首先得到两个链表的长度信息
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		//1. 得到两个链表的长度信息
		int lenA = length(headA), lenB = length(headB);
		//2. 将两个链表的剩余遍历长度置为相同的
		while(lenA > lenB)
		{
			headA = headA.next;
			lenA--;
		}
		while(lenB > lenA)
		{
			headB = headB.next;
			lenB--;
		}
		//3. 齐头并进进行扫描
		while(headA != headB)
		{
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
	
	public int length(ListNode head)
	{
		int len = 0;
		while(head != null)
		{
			head = head.next;
			len++;
		}
		return len;
	}
	
	// solution3 如果某个链表到达尾部，则将其指向另一个链表的头部，继续遍历
	// 假设A和B存在相交的情况，lenA = a+m, lenB=b+m，m是其相交的长度，相交的串位于二者的尾部
	// 如果二者相交，则走过的长度均为a+m+b
	// 如果二者不相交，则走过的长度为a+b（a!=b），a(a=b)
	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
		if(headA==null || headB==null)
			return null;
		ListNode curA = headA, curB = headB;
		while(curA != curB)
		{
			curA = curA==null?headB:curA.next;
			curB = curB==null?headA:curB.next;
		}
		return curA;
	}

}
