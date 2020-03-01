package solution500_599;

/**
 * Created by zjw on 2017/5/1.
 */
public class P563_BinaryTreeTilt {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int findTilt(TreeNode root) {
        if (root == null)   return 0;
        int tiltL = findTilt(root.left), tiltR = findTilt(root.right);
        int left = root.left == null?0:root.left.val;
        int right = root.right == null?0: root.right.val;
        root.val += (left + right);
        return Math.abs(left - right) + tiltL + tiltR;
    }
}
