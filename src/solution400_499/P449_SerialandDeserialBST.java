package solution400_499;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2017/5/12.
 */
public class P449_SerialandDeserialBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)   return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder data = new StringBuilder();
        queue.add(root);
        data.append(root.val);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left == null && cur.right == null)
            {
                data.append('#');
                continue;
            }
            if(cur.left == null)
                data.append('|');
            else {
                data.append(cur.left.val);
                data.append(',');
                queue.add(cur.left);
            }
            if(cur.right == null)
                data.append('|');
            else {
                data.append(cur.right.val);
                data.append(',');
                queue.add(cur.right);
            }
        }
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        TreeNode root = new TreeNode(2);
        return root;
    }

}
