package solution100_199;

/**
 * Created by zjw on 2017/3/31.
 */
public class P100_SameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q==null)    return p == q;
        if(p.val != q.val)  return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
