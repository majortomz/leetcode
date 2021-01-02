package solution100_199;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by zjw on 2017/5/1.
 */
public class P199_BTRightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        result.add(root.val);
        List<Integer> left = rightSideView(root.left), right = rightSideView(root.right);
        result.addAll(right);
        for(int i = right.size(); i<left.size(); i++)
            result.add(left.get(i));
        return result;
    }
}
