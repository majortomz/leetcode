package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 11:12
 * Description: 判断是否为平衡二叉树
 */
public class IsBalancedTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)    return true;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(helper(root.left) - helper(root.right)) <= 1;
    }

    private int helper(TreeNode root) {
        if(root == null)    return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}
