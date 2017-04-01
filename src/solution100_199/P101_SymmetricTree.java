package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/3/31.
 */
public class P101_SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution 1: using queue and stack, Memory Limit Exceed
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.add(root.left);
        queue.add(root.right);
        while (true) {
            int n = queue.size() / 2, size = queue.size();
            int count = 0;
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll(), left, right;
                left = (node == null ? null : node.left);
                right = (node == null ? null : node.right);
                count = left == null ? count + 1 : count;
                count = right == null ? count + 1 : count;
                if (i <= n) {
                    stack.push(node);
                } else {
                    TreeNode top = stack.pop();
                    if (!(top == null && node == null || top != null && node != null && top.val == node.val))
                        return false;
                }
                queue.add(left);
                queue.add(right);
            }
            if (count == 2 * size)
                break;
        }
        return true;
    }

    // Solution 2
    public boolean isSymmetric2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int size = list.size() / 2;
        for (int i = 0; i < size; i++) {
            int pos = list.size() - i - 1;
            if ((list.get(i) == null && list.get(pos) == null) ||
                    (list.get(i)!= null && list.get(i).equals(list.get(pos))) )
                continue;
            else
                return false;
        }
        return true;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
        } else if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            traverse(root.left, list);
            list.add(root.val);
            traverse(root.right, list);
        }
    }
}
