package leetcode_ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/07/18 11:07
 * Description:
 */
public class P236 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        List<TreeNode> pathP = new ArrayList<>(), pathQ = new ArrayList<>();
        search(root, p.val, pathP);
        search(root, q.val, pathQ);

        TreeNode prev = root;
        for(int i = 1, j = 1; i < pathP.size() && j < pathQ.size(); i++, j++) {
            if(pathP.get(i).val != pathQ.get(j).val) {
                break;
            }
            prev = pathP.get(i);
        }
        return prev;
    }

    public boolean search(TreeNode root, int target, List<TreeNode> path) {
        if(root == null) {
            return false;
        }
        if(root.val == target) {
            path.add(root);
            return true;
        }

        path.add(root);
        boolean found = false;
        if(search(root.left, target, path) || search(root.right, target, path)) {
            found = true;
        }
        if(! found) {
            path.remove(path.size() - 1);
        }
        return found;
    }

}
