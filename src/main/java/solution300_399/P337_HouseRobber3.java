package solution300_399;

/**
 * Created by zjw on 2017/5/18.
 */
public class P337_HouseRobber3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int res[] = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        int res[] = {0, 0};     // rob, norob
        if(root == null)    return res;
        int left[] = helper(root.left), right[] = helper(root.right);
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
