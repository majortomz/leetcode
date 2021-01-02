package solution200_299;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2017/4/2.
 */
public class P222_CountCompleteTreeNodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution1 : TLE
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    // 确认该层为最后一层
                    count += i * 2;
                    return count -= (node.left == null ? 2 : 1);
                }
            }
        }
        return count;
    }

    // Solution2: TLE
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        count += countNodes2(root.left) + countNodes2(root.right);
        return count;
    }

    // Solution3: from leetcode discussion
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left), right = height(root.right);
        if (left == 0)
            return 1;
        else if (left == right)
            return (1 << left) + countNodes3(root.right);
        else
            return +(1 << right) + countNodes3(root.left);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + height(root.left);
    }

    // Solution4: from leetcode discussion
    public int countNodes4(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left, right = root.right;
        int height = 0;
        while (left != null && right != null) {
            left = left.left;
            right = right.left;
            height++;
        }
        if(left == null && right == null)
            return (1 << height) + countNodes4(root.right);
        else
            return (1 << height) + countNodes4(root.left);
    }
}
