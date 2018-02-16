package solution700_799;

public class P783_MinDistanceBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int min = 0;

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }

    // [max, small]
    private int[] helper(TreeNode node) {
        if(node == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }

        int res[] = new int[2];
        int[] left = helper(node.left), right = helper(node.right);
        res[0] = Math.max(node.val, right[0]);
        res[1] = Math.min(node.val, left[1]);
        if(node.left != null) {
            min = Math.min(min, node.val - left[0]);
        }
        if(node.right != null) {
            min = Math.min(min, right[1] - node.val);
        }
        return res;
    }

}
