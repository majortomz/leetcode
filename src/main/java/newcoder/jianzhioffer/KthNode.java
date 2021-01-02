package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/10 10:40
 * Description: 二叉搜索树，第K个节点。
 */
public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int k;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        this.k = k;
        return inOrder(pRoot);
    }

    public TreeNode inOrder(TreeNode p) {
        if(p == null)    return null;
        TreeNode lt = inOrder(p.left);
        if(lt != null)    return lt;
        k--;
        if(k == 0)    return p;
        TreeNode rt = inOrder(p.right);
        return rt;
    }
}
