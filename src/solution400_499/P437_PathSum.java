package solution400_499;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2017/3/28.
 */
public class P437_PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Solution 1: recursive version
    public int pathSum(TreeNode root, int sum) {
        if(root == null)    return 0;
        List<Integer> list = new LinkedList<>();
        return traverse(root, list, sum);
    }

    public int traverse(TreeNode root, List<Integer> path, int sum) {
        // If current node is null, return 0
        if(root == null)    return 0;
        int result = 0;
        List<Integer> newPath = new LinkedList<>();
        // 查看当前节点结尾的路径和，个数为根节点到该节点的之间的所有节点
        if(root.val == sum) result++;
        for(Integer val: path) {
            int newVal = val + root.val;
            if(newVal == sum)   result++;
            newPath.add(newVal);
        }
        newPath.add(root.val);
        // 查看左子树和右子树
        result += traverse(root.left, newPath, sum);
        result += traverse(root.right, newPath, sum);
        return result;
    }

    // Solution 2: recursive version, without a linkedlist
    public int pathSum2(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return findPath(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    public int findPath(TreeNode root, int sum){
        int res = 0;
        if(root == null)
            return res;
        if(sum == root.val)
            res++;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

    // Solution3:
}
