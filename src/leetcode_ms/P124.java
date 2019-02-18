package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 14:30
 * Description: Binary Tree Maximum Path Sum
 */
public class P124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left), right = dfs(root.right);
        int pathSum = 0;
        if (left > 0) {
            pathSum += left;
        }
        if (right > 0) {
            pathSum += right;
        }
        max = Math.max(max, pathSum + root.val);

        // max sum from root to some child.
        int sum = Math.max(root.val, Math.max(left + root.val, right + root.val));
        return sum;
    }

}
