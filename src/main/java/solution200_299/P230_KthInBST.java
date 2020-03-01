package solution200_299;

/**
 * Created by zjw on 2017/4/1.
 */
public class P230_KthInBST {

    int cur = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode target =  traverse(root, k);
        return target != null? target.val: 0;
    }

    public TreeNode traverse(TreeNode root, int k) {
        if(root == null )    return root;
        TreeNode child;
        // left
        child = traverse(root.left, k);
        if(child != null)    return child;
        // current node
        cur++;
        if(cur == k)    return root;
        // right
        child = traverse(root.right, k);
        if(child != null)   return child;
        return null;
    }
}
