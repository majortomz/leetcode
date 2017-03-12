package solution;

public class P24_SwapNodesInPairs {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Solution 1
	public ListNode swapPairs(ListNode head) {
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead, p1, p2;
		cur.next = head;
		// 1->2->3->4
		while (cur.next != null && cur.next.next != null) {
			// 记录两个相邻点的引用
			p1 = cur.next;
			p2 = cur.next.next;
			// 相邻点交换
			cur.next = p2;
			p1.next = p2.next;
			p2.next = p1;
			// 当前扫描点后移
			cur = cur.next.next;
		}
		return newHead.next;
	}
	
}
