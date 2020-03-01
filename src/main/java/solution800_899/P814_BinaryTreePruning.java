package solution800_899;

/**
 * Created by zjw on 2018/04/08 9:54
 * Description:
 */
public class P814_BinaryTreePruning {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        return helper(root) > 0 ? root : null;
    }

    public int helper(TreeNode root) {
        if(root == null)    return 0;
        int left = helper(root.left), right = helper(root.right);
        if(left == 0)   root.left = null;
        if(right == 0)  root.right = null;
        return root.val + left + right;
    }
}
