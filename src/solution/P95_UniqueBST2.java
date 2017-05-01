package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2017/5/1.
 */
public class P95_UniqueBST2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new LinkedList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if(start > end)
        {
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i-1), right = helper(i+1, end);
            for(TreeNode ln : left) {
                for(TreeNode rn: right) {
                    TreeNode newRoot = new TreeNode(i);
                    newRoot.left = ln;
                    newRoot.right = rn;
                    result.add(newRoot);
                }
            }
        }
        return result;
    }
}
