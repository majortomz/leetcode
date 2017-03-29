package solution100_199;

/**
 * Created by zjw on 2017/3/29.
 */
public class P110_BalancedBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        return getDepth(root, 0) != -1;
    }

    // 如果是平衡树则返回树的高度，否则返回-1
    public int getDepth(TreeNode root, int depth) {
        if(root == null)    return depth;
        int left, right;
        // 左子树是否是平衡的
        left = getDepth(root.left, depth + 1);
        if(left == -1)   return -1;
        // 右子树是否是平衡的
        right = getDepth(root.right, depth + 1);
        if(right == -1)     return -1;
        // 左右子树都是平衡的，则判断左右子树的深度差
        if(Math.abs(left - right) > 1)
            return -1;
        else
            return  left > right?left:right;
    }
}
