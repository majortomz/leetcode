package solution100_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zjw on 2017/4/1.
 */
public class P102_BTLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution 1: using queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)    return res;
        Queue<TreeNode>  que = new LinkedList<>();
        List<Integer> list;
        que.add(root);
        while(!que.isEmpty())
        {
            int size = que.size();
            list = new LinkedList<>();
            for(int i=1; i<=size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if(node.left != null)   que.add(node.left);
                if(node.right != null)  que.add(node.right);
            }
            res.add(list);
        }
        return res;
    }

    // Solution2: recursive version
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        traverse(root, 0, res);
        return res;
    }

    public void traverse(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null)    return;
        if(level >= res.size())
            res.add(new LinkedList<>());
        res.get(level).add(root.val);
        traverse(root.left, level+1, res);
        traverse(root.right, level+1, res);
    }

}
