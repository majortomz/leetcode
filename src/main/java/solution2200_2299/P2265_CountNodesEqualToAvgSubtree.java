package solution2200_2299;

/**
 * Created by zjw on 2022/05/10 21:19
 * Description:
 */
public class P2265_CountNodesEqualToAvgSubtree {


    public int averageOfSubtree(TreeNode root) {
        return traverse(root)[2];
    }

    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 0};
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int[] res = new int[3];
        res[0] = left[0] + right[0] + 1;
        res[1] = left[1] + right[1] + root.val;
        res[2] = left[2] + right[2] + (root.val == res[1] / res[0] ? 1 : 0);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
