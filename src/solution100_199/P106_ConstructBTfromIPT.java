package solution100_199;

/**
 * Created by zjw on 2017/4/5.
 */
public class P106_ConstructBTfromIPT {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int ls, int le, int rs, int re) {
        int val = postorder[re], pos = ls, len = le - ls + 1;
        for(int i = 0; i<len; i++)
        {
            pos = ls + i;
            if(inorder[pos] == val)
                break;
            pos = le - i;
            if(inorder[pos] == val)
                break;
        }
        int left_count = pos - ls, right_count = le - pos;
        TreeNode node = new TreeNode(val);
        if(left_count > 0)
            node.left = helper(inorder, postorder, ls, pos - 1, rs, rs + left_count - 1);
        if(right_count > 0)
            node.right = helper(inorder, postorder, pos + 1, le,  rs+left_count, re-1);
        return node;
    }

}
