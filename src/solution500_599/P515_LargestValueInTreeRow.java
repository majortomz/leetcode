package solution500_599;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/5/11.
 */
public class P515_LargestValueInTreeRow {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result, int level) {
        if (root == null) return;
        if (level == result.size())
            result.add(root.val);
        else if (root.val > result.get(level))
            result.set(level, root.val);
        level += 1;
        helper(root.left, result, level);
        helper(root.right, result, level);
    }
}
