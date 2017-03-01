package solution200_299;

public class P234_PalindromeLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public boolean isPalindrome(ListNode head) {
        int len = length(head), i = 0;
        int[] record = new int[len/2];
        // 进行压栈操作，数组索引每次加一
        while(i<record.length)
        {
            record[i] = head.val;
            head = head.next;
            i++;
        }
        // 如果链表长度为奇数，中间一个跳过
        if(len%2 == 1)
            head = head.next;
        // 然后进行匹配，同时数组索引每次减一
        while(head!=null)
        {
            i--;
            if(record[i] != head.val)
                return false;
            head = head.next;
        }
        return true;
    }
    
	// 得到链表的长度
    public int length(ListNode head){
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
