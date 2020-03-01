package leetcode_ms;

/**
 * Created by zjw on 2018/08/03 19:21
 * Description: Serialize and Deserialize Binary Tree
 */
public class P297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb, root);
        return sb.toString();
    }

    private void serializeHelper(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            serializeHelper(sb, root.left);
            serializeHelper(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        return deserializeHelper(new int[]{0}, data.split(","));
    }

    private TreeNode deserializeHelper(int[] idx, String[] items) {
        if(items[idx[0]].equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(items[idx[0]]));
        idx[0]++;
        node.left = deserializeHelper(idx, items);
        idx[0]++;
        node.right = deserializeHelper(idx, items);
        return node;
    }
}
