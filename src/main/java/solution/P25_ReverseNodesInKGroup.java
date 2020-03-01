package solution;

public class P25_ReverseNodesInKGroup {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode result = new ListNode(0);
		ListNode cur = result;
		//(a, b, c)(d, e, f)(g, h), k = 3
		while(head != null){
			ListNode st = head, ed;
			for(int i=1; i<=k-1 && head != null; i++)
			{
				head = head.next;
			}
			// 如果剩下的数目小于k，不应当反转，如(g, h)
			if(head == null)
			{
				cur.next = st;
				break;
			}
			// 开始反转 (a, b, c) => (c, b, a)
			ed = head.next;
			ListNode pre = null, tmp = st, next;
			while(tmp != ed)
			{
				next = tmp.next;
				tmp.next = pre;
				pre = tmp;
				tmp = next;
			}
			// cur.next 指向 c； a指向d
			cur.next = head;
			st.next = ed;
			// cur -> a
			cur = st;
			// head -> d
			head = ed;
		}
		return result.next;
	}
}
