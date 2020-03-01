package solution300_399;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2018/06/13 20:41
 * Description:
 */
public class P315_CountOfSmallerNumbers {

    class SegmentTreeNode {
        int start, end;
        int count = 0;
        SegmentTreeNode left, right;
    }

    private SegmentTreeNode buildTree(int start, int end) {
        if(start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode();
        node.start = start;
        node.end = end;
        if(node.start != node.end) {
            int mid = (int) (start + ((long)end - start) / 2);
            node.left = buildTree(start, mid);
            node.right = buildTree(mid + 1, end);
        }
        return node;
    }

    private void updateValueCount(SegmentTreeNode node, int val) {
        if(node == null || val < node.start || val > node.end) {
            return;
        }
        if(node.start == node.end) {
            node.count += 1;
        } else {
            int mid = (int) (node.start + ((long)node.end - node.start) / 2);
            if(val <= mid) {
                updateValueCount(node.left, val);
            } else {
                updateValueCount(node.right, val);
            }
            node.count = (node.left == null ? 0 : node.left.count) + (node.right == null ? 0 : node.right.count);
        }
    }

    private int searchSmaller(SegmentTreeNode node, int val) {
        if(node == null || val < node.start || val > node.end) {
            return 0;
        }

        if(node.start == node.end) {
            return node.start < val ? node.count : 0;
        } else {
            int mid = (int) (node.start + ((long)node.end - node.start) / 2);
            if(val <= mid) {
                return searchSmaller(node.left, val);
            } else {
                return (node.left == null ? 0 :node.left.count) + searchSmaller(node.right, val);
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        SegmentTreeNode root = buildTree(min, max);

        for(int i = nums.length - 1; i >= 0; i--) {
            updateValueCount(root, nums[i]);
            res.add(0, searchSmaller(root, nums[i]));
        }
        return res;
    }

}
