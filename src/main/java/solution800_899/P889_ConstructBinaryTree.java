package solution800_899;

/**
 * Created by zjw on 2018/08/19 10:03
 * Description: Construct Binary Tree from Preorder and Postorder Traversal
 */
public class P889_ConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode helper(int[] pre, int prLo, int prHi, int[] post, int poLo, int poHi) {
        if(prLo > prHi) {
            return null;
        }

        TreeNode cur = new TreeNode(pre[prLo]);
        if(prLo != prHi) {
            int target = pre[prLo + 1], index = 0;
            while(index < poHi && post[index] != target) {
                index++;
            }
            int len = index - poLo + 1;
            cur.left = helper(pre, prLo + 1, prLo + len, post, poLo, index);
            cur.right = helper(pre, prLo + len + 1, prHi, post, index + 1, poHi);
        }
        return cur;
    }

}
