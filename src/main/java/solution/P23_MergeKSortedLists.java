package solution;

import java.awt.Image;

public class P23_MergeKSortedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)	return null;
		int k = lists.length;
		while(k > 1)
		{
			// 两两合并前k个链表
			for(int i=0; i<k; i+=2)
			{
				int pos = i/2;
				if (i+1 < k)
					lists[pos] = merge(lists[i], lists[i+1]);
				else
					lists[pos] = lists[i];
			}
			// 个数减半
			k = k/2 + k%2;
		}
		return lists[0];
	}
	
	public ListNode merge(ListNode l1, ListNode l2){
		// 合并两个有序链表
		ListNode mr = new ListNode(0), cur = mr;
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				cur.next = l1;
				l1 = l1.next;
			}
			else{
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if(l1 == null)
		{
			cur.next = l2;
		}
		if(l2 == null)
		{
			cur.next = l1;
		}
		return mr.next;
	}
}
