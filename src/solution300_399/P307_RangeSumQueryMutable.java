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

    class Solution2 {
        class NumArray {
            TreeNode root;

            class TreeNode {
                TreeNode left, right;
                int sum;
                int start, end;
            }

            private TreeNode buildTree(int[] nums, int start, int end) {
                if(start > end) {
                    return null;
                }
                TreeNode node = new TreeNode();
                node.start = start;
                node.end = end;
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
                this.root = buildTree(nums, 0, nums.length - 1);
            }

            public void update(int i, int val) {
                updateHelper(root, i, val);
            }

            private void updateHelper(TreeNode cur, int i, int val) {
                if(cur == null || i < cur.start || i > cur.end) {
                    return;
                }

                if(cur.start == cur.end) {
                    cur.sum = val;
                } else {
                    int mid = cur.start + (cur.end - cur.start) / 2;
                    if(i <= mid) {
                        updateHelper(cur.left, i, val);
                    } else {
                        updateHelper(cur.right,  i, val);
                    }
                    cur.sum = (cur.left == null ? 0 : cur.left.sum) + (cur.right == null ? 0 : cur.right.sum);
                }
            }

            public int sumRange(int i, int j) {
                return sumRangeHelper(root, i, j);
            }

            private int sumRangeHelper(TreeNode cur, int i, int j) {
                if(cur == null || i < cur.start || j > cur.end) {
                    return 0;
                }

                if(i == cur.start && j == cur.end) {
                    return cur.sum;
                } else {
                    int mid = cur.start + (cur.end - cur.start) / 2;
                    if(mid >= j) {
                        return sumRangeHelper(cur.left, i, j);
                    } else if(mid < i) {
                        return sumRangeHelper(cur.right, i , j);
                    } else {
                        return sumRangeHelper(cur.left, i, mid) + sumRangeHelper(cur.right, mid + 1, j);
                    }
                }
            }
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
