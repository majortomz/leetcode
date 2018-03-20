package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/09 22:13
 * Description:
 */
public class IsSymmetrical {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)    return true;
        return helper(pRoot.left, pRoot.right);
    }

    boolean helper(TreeNode ta, TreeNode tb) {
        if(ta == null || tb == null) {
            return ta == tb;
        }
        return ta.val == tb.val && helper(ta.left, tb.right) && helper(ta.right, tb.left);
    }
}
