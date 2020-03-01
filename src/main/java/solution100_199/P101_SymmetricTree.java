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

    // Solution 1: using queue and stack, Memory Limit Exceed, TLE
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

    // Solution 2, using two queue:left queue and right queue
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)    return true;
        Queue<TreeNode> leftQ = new LinkedList<>(), rightQ = new LinkedList<>();
        leftQ.add(root.left);
        rightQ.add(root.right);
        while(!leftQ.isEmpty()) {
            int size = leftQ.size();
            for(int i=1; i<=size; i++) {
                TreeNode lt = leftQ.poll(), rt = rightQ.poll();
                if(lt == null && rt == null)
                    continue;
                else if(lt == null || rt == null || lt.val != rt.val)
                    return false;
                leftQ.add(lt.left);
                leftQ.add(lt.right);
                rightQ.add(rt.right);
                rightQ.add(rt.left);
            }
        }
        return true;
    }

    // Solution 3: from leetcode discussion, recursive version
    public boolean isSymmetric3(TreeNode root) {
        if(root == null)    return true;
        return help(root.left, root.right);
    }

    // 首先左右子树的根节点同为null或值相等
    // 接着要比较left_child->left_subtree 和 right_child->right_subtree对称
    // 以及left_child->right_subtree 和 right_child->left_subtree对称
    public boolean help(TreeNode lt, TreeNode rt) {
        if(lt == null && rt == null)    return true;
        if(lt == null || rt == null || lt.val != rt.val)
            return false;
        return help(lt.left, rt.right) && help(lt.right, rt.left);
    }
}
