package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/4/1.
 */
public class P103_BTZigzagTraverse {

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
        if(root == null)    return res;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list;
        boolean flag = true;    // true indicates the direction is from left to right
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            list = new LinkedList<>();
            for(int i=1; i<=size; i++)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null)  queue.add(node.right);
            }
            if(flag == false)
                Collections.reverse(list);
            res.add(list);
            flag = !flag;
        }
        return res;
    }

}
