package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 16:45
 * Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)  return false;
        return isSameTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root2 == null;
        }
        return root1.val == root2.val && isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

}
