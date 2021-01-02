package solution100_199;

/**
 * Created by zjw on 2017/3/29.
 */
public class P112_PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)    return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
