package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 17:09
 * Description: 树的镜像
 */
public class TreeMirror {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public void Mirror(TreeNode root) {
        if(root == null)    return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

}
