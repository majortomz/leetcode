package leetcode_ms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zjw on 2018/08/03 16:28
 * Description: Binary Tree Zigzag Level Order Traversal
 */
public class P103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while(size > 0) {
                size--;
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }

                if(leftToRight) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
            }
            leftToRight = !leftToRight;
            if(list.size() != 0) {
                res.add(list);
            }
        }

        return res;
    }

}
