package leetcode_ms;

import java.util.List;

/**
 * Created by zjw on 2018/07/18 10:02
 * Description: Lowest Common Ancestor of a Binary Search Tree
 */
public class P235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // the first way to solve this method is to find path to p and q, and then find the LCA
    // this can be applied to any binary tree

    // binary search tree can be optimized
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root != null && root.val < p.val && root.val < q.val ) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(root != null &&  root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }


}
