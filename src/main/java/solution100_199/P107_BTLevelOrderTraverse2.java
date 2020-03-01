package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/3/28.
 */
public class P107_BTLevelOrderTraverse2 {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<TreeNode>> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        stack.add(list);
        while(true)
        {
            list = new ArrayList<>();
            List<TreeNode> parent = stack.peek();
            for(TreeNode t: parent){
                if(t.left != null)
                    list.add(t.left);
                if(t.right != null)
                    list.add(t.right);
            }
            if(list.isEmpty())
                break;
            stack.add(list);
        }
        while(!stack.isEmpty())
        {
            list = stack.pop();
            List<Integer> intList = new ArrayList<>();
            for(TreeNode t: list)
                intList.add(t.val);
            result.add(intList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
         List<TreeNode> queue = new LinkedList<>();
         List<List<Integer>> result = new LinkedList<>();
         if(root == null)   return result;
         queue.add(root);
         while(!queue.isEmpty())
         {
             int size = queue.size();
             List<Integer> tmp = new LinkedList<>();
             for(int i=1; i<=size; i++)
             {
                 TreeNode t = queue.get(0);
                 queue.remove(0);
                 tmp.add(t.val);
                 if(t.left != null)  queue.add(t.left);
                 if(t.right != null)  queue.add(t.right);
             }
             result.add(0, tmp);
         }
         return result;
    }
}
