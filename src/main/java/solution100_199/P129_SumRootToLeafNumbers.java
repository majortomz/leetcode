package solution100_199;

/**
 * Created by zjw on 2017/5/6.
 */
public class P129_SumRootToLeafNumbers {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null)    return result;
        traverse(root, 0);
        return result;
    }

    public void traverse(TreeNode root, int val) {
        if(root == null)    return;
        val = val * 10 + root.val;
        if(root.right == null && root.left == null)
            result += val;
        else
            traverse(root.left, val);
        traverse(root.right, val);
    }

}
