package solution200_299;

import java.util.ArrayList;
import java.util.List;

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

public class P236_LCAofBT {

    // Solution 1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = new ArrayList<>(), ql = new ArrayList<>();
        int lp = 0, lq = 0;
        // consider the situation that node can not be found, just make it robust
        // but the question says (given two nodes in the tree)
        if(!findNode(root, p, pl) || !findNode(root, q, ql))
            return null;
        if(pl.size() > ql.size())
            lp = pl.size() - ql.size();
        else
            lq = ql.size() - pl.size();
        while(lp < pl.size() && lq < ql.size()) {
            if(pl.get(lp) == ql.get(lq))
            {
                return pl.get(lp);
            }
            lp++; lq++;
        }
        return null;
    }

    public boolean findNode(TreeNode root, TreeNode target, List<TreeNode> path) {
        if(root == null)    return false;
        if(root == target || findNode(root.left, target, path) || findNode(root.right, target, path)) {
            path.add(root);
            return true;
        }
        return false;
    }

    // Solution2: from leetcode discussion, amazing
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left==null? right : right==null?left:root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        P236_LCAofBT pl = new P236_LCAofBT();
        pl.lowestCommonAncestor(root, root, left);
    }
}
