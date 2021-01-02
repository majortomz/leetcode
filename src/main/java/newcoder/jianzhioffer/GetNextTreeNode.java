package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/09 22:07
 * Description:
 */
public class GetNextTreeNode {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)    return null;
        if(pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while(cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        while(pNode.next != null) {
            if(pNode == pNode.next.left) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
