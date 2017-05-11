package solution400_499;

/**
 * Created by zjw on 2017/5/11.
 */
public class P450_DeleteNodeInBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode prev = null, cur = root, left = null, right = null, tmp = null;
        while(cur != null) {
            if(cur.val == key)
            {
                left = cur.left;
                right = cur.right;
                break;
            }
            prev = cur;
            cur = key < cur.val ? cur.left: cur.right;
        }
        if(cur == null)  return root;
        if(left == null || right == null)
            tmp = left == null?right :left;
        else if(right.left == null)
        {
            right.left = left;
            tmp = right;
        }
        else {
            tmp = right;
            while(right.left != null)
                right = right.left;
            right.left = left;
        }
        if(prev == null)
            root = tmp;
        else if(prev.left == cur)
            prev.left = tmp;
        else
            prev.right = tmp;
        return root;
    }
}
