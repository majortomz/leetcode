package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 10:37
 * Description:
 */
public class P101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    public boolean helper(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) {
            return t1 == t2;
        }

        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }

}
