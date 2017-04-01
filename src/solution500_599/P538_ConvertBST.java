package solution500_599;

/**
 * Created by zjw on 2017/4/1.
 */
public class P538_ConvertBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)    return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}
