package solution700_799;

/**
 * Created by zjw on 2018/01/05 14:50
 * Description:
 */
public class P732_MyCalendar3 {
}


class MyCalendarThree {

    class Node {
        public int start, end;
        public Node left, right;
        public int minTimes, maxTimes;

        public Node() {
        }

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.minTimes = this.maxTimes = 0;
        }

    }

    private Node root;

    public MyCalendarThree() {
        root = new Node(0, 1_000_000_000);
    }

    public int book(int start, int end) {
        update(root, root.start, root.end, start, end - 1, 0);
//        return find(root, start, end - 1);
        return root.maxTimes;
    }

    private Node update(Node root, int rs, int re, int start, int end, int bookTimes) {
        if (root == null) {
            root = new Node(rs, re);
            root.minTimes = root.maxTimes = bookTimes;
        }
        if (root.start == start && root.end == end && root.left == null && root.right == null) {
            root.minTimes += 1;
            root.maxTimes += 1;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (start > mid) {
                root.right = update(root.right, mid + 1, root.end, start, end, root.minTimes);
            } else if (end <= mid) {
                root.left = update(root.left, root.start, mid, start, end, root.minTimes);
            } else {
                root.left = update(root.left, root.start, mid, start, mid, root.minTimes);
                root.right = update(root.right, mid + 1, root.end, mid + 1, end, root.minTimes);
            }
            root.maxTimes = Math.max(root.left == null ? 0 : root.left.maxTimes,
                    root.right == null ? 0 : root.right.maxTimes);
            if(root.left != null && root.right != null)
                root.minTimes = Math.min(root.left.minTimes, root.right.minTimes);
        }
        return root;
    }

    private int find(Node root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if(root.start == start && root.end == end) {
            return root.maxTimes;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (start > mid) {
            return find(root.right, start, end);
        } else if (end <= mid) {
            return find(root.left, start, end);
        } else {
            return Math.max(find(root.left, start, mid), find(root.right, mid + 1, end));
        }
    }

}


