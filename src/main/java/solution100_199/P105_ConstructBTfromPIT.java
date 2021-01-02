package solution100_199;

import java.util.Arrays;

/**
 * Created by zjw on 2017/4/1.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class P105_ConstructBTfromPIT {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int val = preorder[0];
        int valPos;
        for (valPos = 0; valPos < inorder.length; valPos++) {
            if (inorder[valPos] == val)
                break;
        }
        TreeNode root = new TreeNode(val);
        if (valPos > 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + valPos),
                    Arrays.copyOfRange(inorder, 0, valPos));
        }
        if (valPos + 1 < inorder.length) {
            root.right = buildTree(Arrays.copyOfRange(preorder, valPos + 1, preorder.length),
                    Arrays.copyOfRange(inorder, valPos + 1, inorder.length));
        }
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length == 0)    return null;
        return helper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int ls, int le, int rs, int re) {
        int val = preorder[ls], valPos;
        for (valPos = rs; valPos < re; valPos++)
            if (inorder[valPos] == val)
                break;
        int leftCount = valPos - rs;
        TreeNode root = new TreeNode(val);
        if (leftCount > 0)
            root.left = helper(preorder, inorder, ls + 1, ls + leftCount + 1, rs, valPos);
        if (valPos + 1 < re)
            root.right = helper(preorder, inorder, ls + leftCount + 1, le, valPos + 1, re);
        return root;
    }

}
