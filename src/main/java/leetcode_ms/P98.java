package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 9:48
 * Description:
 */
public class P98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        int[] res = helper(root, true);
        return res[0] == 1;
    }

    public int[] helper(TreeNode root, boolean isLeft) {
        if(root == null) {
            return null;
        }

        int[] left = helper(root.left, true), right = helper(root.right, false);

        int[] res = new int[]{1, root.val, root.val};
        if(left != null && (left[0] == 0 || root.val <= left[2]) ||
                right != null && (right[0] == 0 || root.val >= right[1])) {
            res[0] = 0;
        }
        if(right != null) {
            res[2] = right[2];
        }
        if(left != null) {
            res[1] = left[1];
        }

        return res;
    }

    private class Solution2 {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long min, long max) {
            if(root == null) {
                return true;
            }
            if(root.val <= min || root.val >= max) {
                return false;
            }
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }

    }

}
