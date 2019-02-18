package leetcode_ms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zjw on 2018/08/06 10:19
 * Description: 145. Binary Tree Postorder Traversal
 */
public class P145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            res.add(0, root.val);
            if(root.left != null) {
                stack.push(root.left);
            }
            if(root.right != null) {
                stack.push(root.right);
            }
        }

        return res;
    }

}
