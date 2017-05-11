package solution100_199;

/**
 * Created by zjw on 2017/5/6.
 */
public class P117_PopulatingNRP2 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root, cur;
        while (levelStart != null) {
            cur = levelStart;
            levelStart = null;
            while (cur != null) {
                if (cur.left == null && cur.right == null) {
                    cur = cur.next;
                    continue;
                }
                // update next levelStart
                if (levelStart == null)
                    levelStart = (cur.left != null ? cur.left : cur.right);
                // update cur.left.next cur.right.next
                if (cur.left != null) cur.left.next = cur.right;
                TreeLinkNode now = (cur.right == null ? cur.left : cur.right);
                cur = cur.next;
                while (cur != null) {
                    if (cur.left == null && cur.right == null) {
                        cur = cur.next;
                        continue;
                    }
                    now.next = cur.left != null ? cur.left : cur.right;
                    break;
                }
            }
        }
    }

}
