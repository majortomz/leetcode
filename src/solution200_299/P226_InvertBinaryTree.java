package solution200_299;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2017/3/30.
 */
public class P226_InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return null;
        TreeNode left, right, tmp;
        tmp = left = invertTree(root.left);
        right = invertTree(root.right);
        root.left = right;
        root.right = tmp;
        return root;
    }

    class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            if(root == null)    return null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            return root;
        }
    }
}
