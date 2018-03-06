package newcoder.jianzhioffer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/03/03 16:21
 * Description: 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class BTFindPath {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), root, target, 0);
        return list;
    }

    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, TreeNode root, int target, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            res.add(new ArrayList<>(path));
        }
        helper(res, path, root.left, target, sum);
        helper(res, path, root.right, target, sum);

        path.remove(path.size() - 1);
    }
}
