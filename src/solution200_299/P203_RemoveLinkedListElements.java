package solution200_299;

public class P203_RemoveLinkedListElements {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode curNode = null, first = null;
        while(head != null)
        {
        	if(head.val != val)
        	{
        		if(first == null)
        		{
        			first = curNode = head;
        		}
        		else{
        			curNode.next = head;
        			curNode = curNode.next;
        		}
        	}
        	head = head.next;
        }
        if(curNode != null) curNode.next = null;
        return first;
    }
	
	public static void main(String[] args){
		System.out.println("sss");
		P203_RemoveLinkedListElements pr = new P203_RemoveLinkedListElements();
		ListNode head = pr.new ListNode(1);
		System.out.println(pr.removeElements(head, 2).val);
		
	}
}
