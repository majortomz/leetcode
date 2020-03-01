package solution700_799;

/**
 * Created by zjw on 2017/12/22.
 */
public class P731_MyCalendar2 {

}

class MyCalendarTwo {

    class Node {
        public int start, end;
        public Node left, right;

        public int bookTimes;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            bookTimes = 0;
        }
    }

    private Node root;

    public MyCalendarTwo() {
        this.root = new Node(0, 1_000_000_000);
    }

    public boolean book(int start, int end) {
        if(find(root, start, end - 1))
            return false;
        update(root, root.start, root.end, 0, start, end - 1);
        return true;
    }

    private boolean find(Node root, int start, int end) {
        if(root == null) {
            return false;
        }
        if(root.bookTimes >= 2) {
            return true;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if(end <= mid) {
            return find(root.left, start, end);
        } else if(start > mid) {
            return find(root.right, start, end);
        } else {
            return find(root.left, start, mid) || find(root.right, mid + 1, end);
        }
    }

    private Node update(Node root, int rs, int re, int bookTimes, int start, int end) {
        if(root == null) {
            root = new Node(rs, re);
            root.bookTimes = bookTimes;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if(root.start == start && root.end == end && root.left == null && root.right == null) {
            root.bookTimes += 1;
        }
        else {
            if(end <= mid) {
                root.left = update(root.left, root.start, mid, root.bookTimes, start, end);
            } else if(start > mid) {
                root.right = update(root.right, mid + 1, root.end, root.bookTimes, start, end);
            } else {
                root.left = update(root.left, root.start, mid, root.bookTimes, start, mid);
                root.right = update(root.right, mid + 1, root.end, root.bookTimes,mid + 1, end);
            }
            if(root.left != null && root.right != null)
                root.bookTimes = Math.min(root.left.bookTimes, root.right.bookTimes);
        }
        return root;
    }

}
