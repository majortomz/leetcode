package solution;

public class P83_RemoveDuplicatesFromSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	/*
	 * 
	 */
	public ListNode deleteDuplicates(ListNode head){
		if(head == null) return head;
		// node记录当前要遍历的位置，cur_pos记录当前去重列表的最后一个位置
		ListNode node = head.next, cur_pos = head;
		while(node != null)
		{
			if(node.val != cur_pos.val)
			{
				//如果和cur_pos的值不同，则要插入node.val
				//即将cur_pos后移，然后赋值
				cur_pos = cur_pos.next;
				cur_pos.val = node.val;
			}
			node = node.next;
		}
		//将去重链表最后一个node的next置为null
		cur_pos.next = null;
		return head;
	}
}
