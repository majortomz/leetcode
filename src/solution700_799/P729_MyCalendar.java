package solution700_799;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/12/20.
 */
public class P729_MyCalendar {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        int[][] cases = {{47,50},{33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}};
        for(int[] test: cases) {
            calendar.book(test[0], test[1]);
        }
    }
}

class MyCalendar2 {

    List<int[]> list = new ArrayList<>();

    public boolean book(int start, int end) {
        for(int[] item : list) {
            if(item[0] <= start && start <= item[1] || item[0] <= end && end <= item[1]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }

}


class MyCalendar {

    class Node {
        int start, end;
        Node left, right;  // left: [start, mid-1], right: [mid, end]
        boolean isBooked;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node root;

    public MyCalendar() {
        root = new Node(0, 1_000_000_000);
    }

    public boolean book(int start, int end) {
        if(find(root, start, end - 1))
            return false;
        update(root, root.start, root.end, start, end-1);
        return true;
    }

    private boolean find(Node root, int start, int end) {
        if(root == null) {
            return false;
        }
        if(root.isBooked) {
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

    private Node update(Node root, int rs, int re, int start, int end) {
        if(root == null) {
            root = new Node(rs, re);
        }
        if(root.start == start && root.end == end) {
            root.isBooked = true;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if(start > mid) {
                root.right = update(root.right, mid + 1, root.end, start, end);
            } else if(end <= mid) {
                root.left = update(root.left, root.start, mid, start, end);
            } else {
                root.left = update(root.left, root.start, mid, start, mid);
                root.right = update(root.right, mid + 1, root.end, mid + 1, end);
            }
            if(root.left != null && root.right != null && root.left.isBooked && root.right.isBooked)
                root.isBooked = true;
        }
        return root;
    }


}