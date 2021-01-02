package leetcode_ms;

/**
 * Created by zjw on 2018/08/07 10:38
 * Description:
 */
public class P654 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            TreeNode cur = new TreeNode(nums[i]);
            if(nums[i] > root.val) {
                cur.left = root;
                root = cur;
            } else {
                TreeNode prev = root;
                while(prev.right != null && prev.right.val > cur.val) {
                    prev = prev.right;
                }
                cur.left = prev.right;
                prev.right = cur;
            }
        }
        return root;
    }
}
