package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/05 16:38
 * Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBSTtoList {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        return helper(pRootOfTree)[0];
    }

    // 返回该子树转成双向链表后的头尾节点
    private TreeNode[] helper(TreeNode cur) {
        if(cur == null) return new TreeNode[]{};
        TreeNode[] left = helper(cur.left), right = helper(cur.right);
        TreeNode[] res = new TreeNode[2];
        if(left.length != 0) {
            left[1].right = cur;
            cur.left = left[1];
        }
        if(right.length != 0) {
            right[0].left = cur;
            cur.right = right[0];
        }
        res[0] = left.length == 0 ? cur : left[0];
        res[1] = right.length == 0 ? cur : right[1];
        return res;
    }
}
