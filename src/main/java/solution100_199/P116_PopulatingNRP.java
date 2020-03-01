package solution100_199;

/**
 * Created by zjw on 2017/5/6.
 */
public class P116_PopulatingNRP {
    // Populating Next Right Pointers in Each Node

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        TreeLinkNode cleft = root.left, cright = root.right;
        while(cleft != null && cright != null)
        {
            cleft.next = cright;
            cleft = cleft.right;
            cright = cright.left;
        }
        connect(root.left);
        connect(root.right);
    }

    // Solution2: from leetcode discussion
    public void connect2(TreeLinkNode root) {
        TreeLinkNode levelStart = root, cur;
        while(levelStart != null) {
            cur = levelStart;
            while(cur != null)
            {
                if(cur.left != null)    cur.left.next = cur.right;
                if(cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }
}
