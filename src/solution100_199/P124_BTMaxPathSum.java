package solution100_199;

/**
 * Created by zjw on 2017/5/18.
 */
public class P124_BTMaxPathSum {
    // Binary Tree Maximum Path sum, pay attention to negative node value

    int max = Integer.MIN_VALUE;
    // Adjusted Code
    public int maxPathSum(TreeNode root) {
        if(root == null)    return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        int left = 0, right = 0;
        // handle negative case
        if(root.left != null)
            left = Math.max(helper(root.left), left);
        if(root.right != null)
            right = Math.max(helper(root.right), right);
        int sum = left + right + root.val;
        max = Math.max(sum, max);
        return Math.max(left, right) + root.val;
    }

    // Former code, however, TLE, why?
    public int maxPathSum2(TreeNode root) {
        helper2(root);
        return max;
    }

    public int helper2(TreeNode root) {
        if(root == null)    return 0;
        // handle negative case
        int left = Math.max(helper(root.left), 0), right = Math.max(helper(root.right), 0);
        int sum = left + right + root.val;
        max = Math.max(sum, max);
        return Math.max(left, right) + root.val;
    }
}
