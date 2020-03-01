package newcoder.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2018/03/10 10:09
 * Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintHierarchy {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)    return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        while(!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> subRes = new ArrayList<Integer>();
            while(count > 0) {
                TreeNode cur = queue.poll();
                subRes.add(cur.val);
                if(cur.left != null)    queue.offer(cur.left);
                if(cur.right != null)    queue.offer(cur.right);
                count--;
            }
            res.add(subRes);
        }
        return res;
    }
}
