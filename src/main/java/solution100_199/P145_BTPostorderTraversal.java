package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/5/18.
 */
public class P145_BTPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)    return list;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.peek();
            if(set.contains(cur))
            {
                list.add(cur.val);
                stack.pop();
                set.remove(cur);
                continue;
            }
            set.add(cur);
            if(cur.right != null)    stack.add(cur.right);
            if(cur.left != null)    stack.add(cur.left);
        }
        return list;
    }

    // Solution 2: From leetcode discussion, without set
    public List<Integer> postorderTraversal2(TreeNode root) {
        if(root == null ) return new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode curr;
        List<Integer> list = new LinkedList<>();
        while(!stack.isEmpty()) {
            curr= stack.pop();
            if(curr.left != null) {
                stack.add(curr.left);
            }

            if(curr.right != null) {
                stack.add(curr.right);
            }
            list.add(0,curr.val);
        }

        return list;
    }
}
