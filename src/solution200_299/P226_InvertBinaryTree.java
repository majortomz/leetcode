package solution200_299;

/**
 * Created by zjw on 2017/3/30.
 */
public class P226_InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return null;
        TreeNode left, right, tmp;
        tmp = left = invertTree(root.left);
        right = invertTree(root.right);
        root.left = right;
        root.right = tmp;
        return root;
    }
}
