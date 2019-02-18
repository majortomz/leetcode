package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 10:33
 * Description:
 */
public class P117 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode hHead = root, pHead = new TreeLinkNode(-1);
        while(hHead != null) {
            TreeLinkNode nextHead = null, prev = pHead;

            while(hHead != null) {
                if(hHead.left != null || hHead.right != null) {
                    nextHead = (hHead.left == null ? hHead.right : hHead.left);
                    break;
                }
                hHead = hHead.next;
            }

            while(hHead != null) {
                if(hHead.left != null) {
                    prev.next = hHead.left;
                    prev = hHead.left;
                }
                if(hHead.right != null) {
                    prev.next = hHead.right;
                    prev = hHead.right;
                }
                hHead = hHead.next;
            }

            hHead = nextHead;
        }
    }

}
