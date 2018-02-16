package solution700_799;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/02/04 10:57
 * Description:
 */
public class P776_SplitSST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode lte = new TreeNode(0), gt = new TreeNode(0);
        helper(root, V, lte, gt);
        return new TreeNode[]{lte.right, gt.left};
    }

    public void helper(TreeNode node, int v, TreeNode lte, TreeNode gt) {
        if(node == null) return;
        if(node.val <= v) {
            lte.right = node;
            TreeNode right = node.right;
            node.right = null;
            helper(right, v, node, gt);
        } else {
            gt.left = node;
            TreeNode left = node.left;
            node.left = null;
            helper(left, v, lte, node);
        }
    }

}
