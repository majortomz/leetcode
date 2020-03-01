package leetcode_ms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2018/08/06 21:19
 * Description:
 */
public class P513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int levelCount = 0, val;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return val;
    }

    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level > levelCount) {
            levelCount = level;
            val = root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int findLeftMostNode2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }
}
