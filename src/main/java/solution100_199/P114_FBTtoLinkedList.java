package solution100_199;

/**
 * Created by zjw on 2017/5/11.
 */
public class P114_FBTtoLinkedList {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))    return;
        TreeNode left = root.left, right = root.right;
        root.left = null;
        if(left == null || right == null) {
            TreeNode tmp = left != null? left: right;
            if(tmp.left == null && tmp.right == null)
            {
                root.right = tmp;
                return;
            }
        }
        flatten(left);
        flatten(right);
        root.right = left;
        while(root.right != null)
            root = root.right;
        root.right = right;
    }
}
