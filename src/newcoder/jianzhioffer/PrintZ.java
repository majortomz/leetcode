package newcoder.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by zjw on 2018/03/09 22:38
 * Description:
 */
public class PrintZ {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)    return res;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(pRoot);
        boolean leftToRight = false;
        res.add(new ArrayList<Integer>(Arrays.asList(pRoot.val)));
        while(list.size() > 0) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> subRes = new ArrayList<Integer>();
            if(leftToRight) {
                for(int i = list.size() - 1; i >= 0; i--) {

                    if(list.get(i).left != null ) {
                        subRes.add(list.get(i).left.val);
                        next.add(list.get(i).left);
                    }
                    if(list.get(i).right != null) {
                        subRes.add(list.get(i).right.val);
                        next.add(list.get(i).right);
                    }
                }
            } else {
                for(int i = list.size() - 1; i >= 0; i--) {
                    if(list.get(i).right != null) {
                        subRes.add(list.get(i).right.val);
                        next.add(list.get(i).right);
                    }
                    if(list.get(i).left != null ) {
                        subRes.add(list.get(i).left.val);
                        next.add(list.get(i).left);
                    }
                }
            }
            leftToRight = !leftToRight;
            list = next;
            if(subRes.size() > 0)
                res.add(subRes);
        }
        return res;
    }
}
