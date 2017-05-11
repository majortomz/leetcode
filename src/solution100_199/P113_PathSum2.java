package solution100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/5/11.
 */
public class P113_PathSum2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 有负数
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, sum, result, path, 0);
        return result;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> result, ArrayList<Integer> path, int level) {
        if(root == null) return;
        sum -= root.val;
        path.add(root.val);
        if(sum == 0 && root.left == null && root.right == null)
        {
            result.add((ArrayList<Integer>)path.clone());
        }
        else{
            helper(root.left, sum, result, path, level + 1);
            helper(root.right, sum, result, path, level + 1);
        }
        path.remove(level);
    }
}
