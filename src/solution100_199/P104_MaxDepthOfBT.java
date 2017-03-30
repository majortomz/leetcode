package solution100_199;

/**
 * Created by zjw on 2017/3/30.
 */
public class P104_MaxDepthOfBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left), right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
