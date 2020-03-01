package leetcode_ms;

import java.util.Stack;

/**
 * Created by zjw on 2018/08/05 17:03
 * Description:
 */
public class P173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if(stack.isEmpty()) {
                return 0;
            }

            TreeNode cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return val;
        }
    }

}
