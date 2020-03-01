package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/01 15:51
 * Description:
 */
public class RebuildBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return helper(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode helper(int[] pre, int[] in, int ps, int pe, int is, int ie) {
        if(ps > pe || is > ie) return null;
        TreeNode node = new TreeNode(pre[ps]);
        int index = is;
        while(index <= ie && in[index] != node.val) {
            index++;
        }
        int len = index - is;
        node.left = helper(pre, in, ps + 1, ps + len, is, is + len - 1);
        node.right = helper(pre, in, ps + len + 1, pe, is + len + 1, ie);
        return node;
    }

}
