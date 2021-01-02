package leetcode_ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zjw on 2018/08/06 10:09
 * Description:
 */
public class P144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return list;

    }

}
