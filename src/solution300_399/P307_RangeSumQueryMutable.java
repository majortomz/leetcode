package solution300_399;

import javax.swing.text.Segment;

/**
 * Created by zjw on 2017/11/23.
 */

// TLE
public class P307_RangeSumQueryMutable {

    class NumArray {

        private int[] nums, sums;

        public NumArray(int[] nums) {
            if(nums == null) {
                return;
            }
            this.nums = nums;
            sums = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                sums[i] = nums[i] + (i == 0 ? 0 : sums[i-1]);
            }
        }

        public void update(int i, int val) {
            if(nums == null || i > nums.length || i < 0)    return;
            for(int k = i; k < nums.length; k++) {
                sums[k] = sums[k] - nums[i] + val;
            }
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            if(nums == null)
                return 0;
            return sums[j] - (i == 0 ? 0 : sums[i-1]);
        }
    }
}

// SegmentTree
class P307_RangeSumQueryMutable2 {

    class NumArray {

        private SegmentTreeNode root;

        class SegmentTreeNode {
            int start, end;
            SegmentTreeNode left, right;
            int sum;

            public SegmentTreeNode(int start, int end) {
                this.start = start;
                this.end = end;
                this.left = this.right = null;
                this.sum = 0;
            }
        }

        private SegmentTreeNode buildTree(int[] nums, int start, int end) {
            if(start > end)
                return null;
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if(start == end) {
                node.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                node.left = buildTree(nums, start, mid);
                node.right = buildTree(nums, mid + 1, end);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }

        public NumArray(int[] nums) {
            if(nums == null || nums.length == 0)
                return;
            root = buildTree(nums, 0, nums.length - 1);
        }

        public void update(int i, int val) {
            update(root, i, val);
        }

        public void update(SegmentTreeNode node, int start, int val) {
            if(start < node.start || start > node.end)
                return;
            if(node.start == node.end) {
                node.sum = val;
                return;
            }
            int mid = node.start + (node.end - node.start) / 2;
            if(start <= mid) {
                update(node.left, start, val);
            } else {
                update(node.right, start, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        public int sumRange(SegmentTreeNode node, int start, int end) {
            if(node.start == start && node.end == end) {
                return node.sum;
            }
            int mid = node.start + (node.end - node.start) / 2;
            if(end <= mid) {
                return sumRange(node.left, start, end);
            } else if(start > mid) {
                return sumRange(node.right, start, end);
            } else {
                return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
            }
        }
    }
}
