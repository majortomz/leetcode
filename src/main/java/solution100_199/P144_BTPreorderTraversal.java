package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/5/1.
 */
public class P144_BTPreorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // first: initialize
        while(cur != null)
        {
            stack.push(cur);
            cur = cur.left;
        }
        // second: traverse
        while(!stack.isEmpty())
        {
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return result;
    }

    // Solution1:
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // first: initialize
        while(cur != null) {
            result.add(cur.val);
            stack.push(cur);
            cur = cur.left;
        }
        // second: traverse
        while(!stack.isEmpty()) {
            cur = stack.pop();
            cur = cur.right;
            while(cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
        }
        return result;
    }

    // Solution2: from Leetcode discussion version
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)    return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
        return result;
    }
}
