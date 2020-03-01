package solution;

/**
 * Created by zjw on 2017/5/11.
 */
public class P98_ValidateBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // node's value range [-2^31, 2^31-1]
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        return helper2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if(root == null)    return true;

        return (root.left == null || root.left.val > min && root.left.val < root.val) &&
                (root.right == null || root.right.val > root.val && root.right.val < max) &&
                helper(root.left, min, root.val) &&
                helper(root.right, root.val, max);
    }

    // Solution 2
    public boolean isValidBST2(TreeNode root) {
        if(root == null)    return true;
        return helper2(root, (long)Integer.MIN_VALUE, (long)Integer.MAX_VALUE);
    }

    public boolean helper2(TreeNode root, long lower, long higher) {
        if(root == null)    return true;
        if(lower > higher) return false;
        // the type of TreeNode.val is int, and may underflow or overflow, explicit cast to long is needed
        return root.val >=lower && root.val <= higher &&
                helper2(root.left, lower, (long)root.val-1) && helper2(root.right, (long)root.val+1, higher);
    }
}
