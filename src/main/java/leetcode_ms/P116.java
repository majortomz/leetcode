package leetcode_ms;

/**
 * Created by zjw on 2018/08/03 16:58
 * Description:  Populating Next Right Pointers in Each Node
 */
public class P116 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        connect(root.left);
        connect(root.right);

        TreeLinkNode left = root.left, right = root.right;
        while(left != null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}
