package solution800_899;

import java.util.Stack;

/**
 * Created by zjw on 2018/09/02 9:42
 * Description:
 */
public class P897_IncreasingOrderSearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] res = helper(root);
        return res[0];
    }

    public TreeNode[] helper(TreeNode root) {
        if(root == null) {
            return new TreeNode[]{null, null};
        }

        TreeNode[] left = helper(root.left), right = helper(root.right);
        TreeNode[] res = new TreeNode[]{root, root};
        if(root.left != null) {
            res[0] = left[0];
            left[1].right = root;
        }
        if(root.right != null) {
            root.right = right[0];
            res[1] = right[1];
        }
        root.left = null;
        return res;
    }

}
