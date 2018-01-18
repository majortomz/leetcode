package solution300_399;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by zjw on 2018/01/17 10:22
 * Description:
 */
public class P352_DisjointIntervals {
    // Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    class SummaryRanges {

        class TreeNode {
            int start, end;

            public TreeNode() {
            }

            public TreeNode(int start, int end) {
                this.start = start;
                this.end = end;
            }

            TreeNode lChild, rChild;
        }

        TreeNode root;
        List<Interval> intervals = null;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
        }

        public void addNum(int val) {
            root = addTreeNode(root, val);
            this.intervals = null;
        }

        private TreeNode addTreeNode(TreeNode root, int val) {
            if (root == null) {
                root = new TreeNode(val, val);
                return root;
            }
            if (val + 1 == root.start) {
                root.start = val;
                // merge
                int aim = val - 1;
                TreeNode curNode = root.lChild, parent = root;
                while(curNode != null) {
                    if(curNode.end == aim) {
                        root.start = curNode.start;
                        if(parent == root) {
                            parent.lChild = curNode.lChild;
                        } else {
                            parent.rChild = curNode.lChild;
                        }
                        break;
                    } else {
                        parent = curNode;
                        curNode = curNode.rChild;
                    }
                }
            } else if (val - 1 == root.end) {
                root.end = val;
                // merge
                TreeNode curNode = root.rChild, parent = root;
                int aim = val + 1;
                while(curNode != null) {
                    if(curNode.start == aim) {
                        root.end = curNode.end;
                        if(parent == root) {
                            parent.rChild = curNode.rChild;
                        } else {
                            parent.lChild = curNode.rChild;
                        }
                        break;
                    } else {
                        parent = curNode;
                        curNode = curNode.lChild;
                    }
                }
            } else if (val < root.start) {
                root.lChild = addTreeNode(root.lChild, val);
            } else if (val > root.end) {
                root.rChild = addTreeNode(root.rChild, val);
            }
            return root;
        }

        public List<Interval> getIntervals() {
            if (intervals == null) {
                this.intervals = new ArrayList<>();
                dfs(root, this.intervals);
            }
            return intervals;
        }

        private void dfs(TreeNode root, List<Interval> result) {
            if (root == null) {
                return;
            }
            dfs(root.lChild, result);
            result.add(new Interval(root.start, root.end));
            dfs(root.rChild, result);
        }

    }

    // from leetcode discussion
    class Solution2 {
        TreeMap<Integer, Interval> treeMap;

        public Solution2() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            if(treeMap.containsKey(val)) {
                return;
            }
            Integer l = treeMap.lowerKey(val);
            Integer h = treeMap.higherKey(val);
            if(l != null && h != null && treeMap.get(l).end + 1 == val && h == val + 1) {
                treeMap.get(l).end = treeMap.get(h).end;
                treeMap.remove(h);
            } else if(l != null && treeMap.get(l).end + 1 >= val) {
                treeMap.get(l).end = Math.max(treeMap.get(l).end, val);
            } else if(h != null && h == val + 1) {
                treeMap.put(val, new Interval(val, treeMap.get(h).end));
                treeMap.remove(h);
            } else {
                treeMap.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(treeMap.values());
        }
    }

}
