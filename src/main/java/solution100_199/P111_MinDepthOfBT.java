package solution100_199;

/**
 * Created by zjw on 2017/3/31.
 */
public class P111_MinDepthOfBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        int left = minDepth(root.left), right = minDepth(root.right);
        if(left == 0 || right == 0)
            return Math.max(left, right) + 1;
        else
            return Math.min(left, right) + 1;
    }

}
