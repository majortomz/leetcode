package solution100_199;

public class P109_ConvertSortedListToBBST {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Solution 1: TLE 
	// 每次查找当前链表的中点，作为当前树的根节点，然后递归得到中点左、右两边的Tree
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)	return null;
		return insertNode(head, null);
	}
	
	public TreeNode insertNode(ListNode head, ListNode end)
	{
		if(head == end)	return null;
		TreeNode node;
		// 找到中点
		ListNode p1 = head, p2 = head;
		while(p2.next != end && p2.next.next != end)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}
		node = new TreeNode(p1.val);
		node.left = insertNode(head, p1);
		node.right = insertNode(p1.next, end);
		return node;
	}
	
	// Solution 2: 
	
}
