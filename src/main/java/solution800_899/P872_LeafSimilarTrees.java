package solution800_899;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/07/22 13:08
 * Description:
 */
public class P872_LeafSimilarTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> values1 = new ArrayList<>(), values2 = new ArrayList<>();
        getLeftValues(root1, values1);
        getLeftValues(root2, values2);

        if(values1.size() != values2.size()) {
            return false;
        }

        for(int i = 0; i < values1.size(); i++) {
            if(values1.get(i) != values2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void getLeftValues(TreeNode root, List<Integer> values) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            values.add(root.val);
            return;
        }

        getLeftValues(root.left, values);
        getLeftValues(root.right, values);
    }

}
