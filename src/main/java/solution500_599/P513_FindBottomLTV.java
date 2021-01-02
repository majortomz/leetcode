package solution500_599;

/**
 * Created by zjw on 2017/5/11.
 */

// Find Bottom Left Tree Value
public class P513_FindBottomLTV {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int lastRow = 0;
    TreeNode result = null;

    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return result.val;
    }

    public void helper(TreeNode root, int level) {
        if(root == null)    return;
        if(root.left == null && root.right == null && level > lastRow) {
            result = root;
            lastRow = level;
            return;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
