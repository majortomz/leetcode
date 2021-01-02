package solution;

public class P92_ReverseLinkedList2 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n)
			return head;
		ListNode curNode = head, newHead = new ListNode(0), pre;
		newHead.next = head;
		pre = newHead; 				// pre记录第一个反转节点的前继节点
		// 找到要反转的第一个节点
		while (m > 1) {
			pre = curNode;
			curNode = curNode.next;
			m--;
			n--;
		}
		// 开始反转， first:第一个反转节点；tm_pre：暂时记录反转节点的前继节点；
		// nextNode：当前反转节点的后继节点
		ListNode first = curNode, tm_pre = null, nextNode = null; 
		while (n > 1) {
			nextNode = curNode.next;	// 记录当前反转节点的后继节点
			curNode.next = tm_pre;		// 将当前反转节点的next指向tem_pre
			tm_pre = curNode;			// 将temp_pre指向当前反转节点
			curNode = nextNode;			// 当前反转节点后移
			n--;
		}
		nextNode = curNode.next;		// 记录最后一个反转节点的next
		first.next = nextNode;			
		curNode.next = tm_pre;
		pre.next = curNode;
		return newHead.next;
	}
}
