package solution800_899;

/**
 * Created by zjw on 2018/07/09 20:18
 * Description:
 */
public class P866_SmallestSubtree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        getMaxDepth(root, 0);
        return helper(root, 0);
    }

    private void getMaxDepth(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        depth++;
        maxDepth = Math.max(maxDepth, depth);
        getMaxDepth(root.left, depth);
        getMaxDepth(root.right, depth);
    }

    private TreeNode helper(TreeNode root, int depth) {
        depth++;
        if(root == null || depth == maxDepth) {
            return root;
        }

        TreeNode left = helper(root.left, depth), right = helper(root.right, depth);

        if(left == null) {
            return right;
        } else if(right == null) {
            return left;
        } else {
            return root;
        }
    }

}
