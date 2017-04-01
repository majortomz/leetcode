package solution200_299;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2017/3/31.
 */
public class P257_BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution 1: 23ms
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) return list;
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left.isEmpty() && right.isEmpty())
            left.add(String.valueOf(root.val));
        else {
            left.addAll(right);
            for (int i = 0; i < left.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(root.val).append("->").append(left.get(i));
                left.set(i, sb.toString());
            }
        }
        return left;
    }

    // Solution 2, from leetcode discussion, comparing efficiency, 17ms
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list= new LinkedList<String>();
        if(root == null)    return list;
        traverse(root, "", list);
        return list;
    }

    public void traverse(TreeNode root, String path, List<String> answer) {
        if(root.left == null && root.right == null)
            answer.add(path + root.val);
        if(root.left != null)   traverse(root.left, path+ root.val + "->", answer);
        if(root.right != null)  traverse(root.right, path+root.val + "->", answer);
    }
}
