package solution400_499;

/**
 * Created by zjw on 2017/3/29.
 */
public class P404_SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root,false);
    }

    public int traverse(TreeNode root, boolean isLeft) {
        int res = 0;
        if(root == null)    return res;
        if(root.left == null && root.right == null && isLeft)
            res += root.val;
        res += traverse(root.left, true);
        res += traverse(root.right, false);
        return res;
    }
}
