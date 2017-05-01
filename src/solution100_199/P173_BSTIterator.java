package solution100_199;

import java.util.Stack;

/**
 * Created by zjw on 2017/5/1.
 */
public class P173_BSTIterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> stack = new Stack<>();

    public P173_BSTIterator(TreeNode root) {
        // initialize
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
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
        // current node's value is the next smallest number
        TreeNode cur = stack.pop();
        int nextVal = cur.val;
        // get current node's right child and right's child's left child forest
        cur = cur.right;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return nextVal;
    }
}
