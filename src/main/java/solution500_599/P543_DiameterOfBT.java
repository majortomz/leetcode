package solution500_599;

/**
 * Created by zjw on 2017/3/30.
 */
public class P543_DiameterOfBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root, 0);
        return max;
    }

    public int traverse(TreeNode root, int depth) {
        if (root == null) return 0;
        int left = traverse(root.left, 0), right = traverse(root.right, 0);
        int diameter = left + right;
        max = diameter > max ? diameter : max;
        return depth + 1 + Math.max(left, right);
    }

}
