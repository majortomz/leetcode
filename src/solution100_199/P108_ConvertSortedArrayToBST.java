package solution100_199;

/**
 * Created by zjw on 2017/3/30.
 */
public class P108_ConvertSortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution 1: recursive version
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)    return null;
        return insertNode(nums, 0, nums.length - 1);
    }

    public TreeNode insertNode(int[] nums, int left, int right) {
        if(left > right)    return null;
        int mid = (left + right) / 2;
        // treat the median as current root node
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insertNode(nums, left, mid-1);
        node.right = insertNode(nums, mid + 1, right);
        return node;
    }

}
