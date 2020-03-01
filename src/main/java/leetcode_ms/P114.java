package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 20:00
 * Description:
 */
public class P114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        if(prev != null) {
            prev.right = root;
        }


        prev = root;
        TreeNode left = root.left, right = root.right;
        root.right = root.left = null;
        flatten(left);
        flatten(right);
    }

}
