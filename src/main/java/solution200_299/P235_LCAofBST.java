package solution200_299;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/3/28.
 */
public class P235_LCAofBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution1: it is BST , recursive version
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = new ArrayList<>(), ql = new ArrayList<>();
        findNode2(root, p, pl);
        findNode2(root, q, ql);
        int lp = 0, lq = 0;
        if (pl.size() > ql.size())
            lp = pl.size() - ql.size();
        else
            lq = ql.size() - pl.size();
        while (lp < pl.size() && lq < ql.size() && pl.get(lp) != ql.get(lq)) {
            lp++;
            lq++;
        }
        return pl.get(lp);
    }

    public void findNode2(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == target) {
            path.add(root);
            return;
        }
        if (root.left != null && target.val < root.val)
            findNode2(root.left, target, path);
        else if (root.right != null && target.val > root.val)
            findNode2(root.right, target, path);
        path.add(root);
    }

    public boolean findNode(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        if (root == target) {
            path.add(root);
            return true;
        }
        boolean left = findNode(root.left, target, path);
        boolean right = findNode(root.right, target, path);
        if (left || right)
            path.add(root);
        return left || right;
    }

    // Solution2: Non-recursive version
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;
        while (root != null) {
            if (p.val == root.val || q.val == root.val || (p.val < root.val && q.val > root.val) ||
                    (p.val > root.val && q.val < root.val)) {
                lca = root;
                break;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return lca;
    }
}
