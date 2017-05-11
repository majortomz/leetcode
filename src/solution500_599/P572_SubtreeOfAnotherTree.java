package solution500_599;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/5/10.
 */
public class P572_SubtreeOfAnotherTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 树里面可能会有多个值相同的节点
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<TreeNode> posList = new ArrayList<TreeNode>();
        findTRoot(s, t, posList);
        for(TreeNode pos : posList) {
            if(isSame(pos, t) == true)  return true;
        }
        return false;
    }

    public void findTRoot(TreeNode s, TreeNode t, List<TreeNode> posList) {
        if(s == null || t == null)   return;
        if(s.val == t.val)  posList.add(s);
        findTRoot(s.left, t, posList);
        findTRoot(s.right, t, posList);
    }

    public boolean isSame(TreeNode pos, TreeNode t) {
        if(pos == null && t == null)    return true;
        else if(pos == null || t == null)   return false;
        return pos.val == t.val && isSame(pos.left, t.left) && isSame(pos.right, t.right);
    }
}
