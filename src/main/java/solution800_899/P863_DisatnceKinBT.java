package solution800_899;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/07/01 9:39
 * Description:
 */
public class P863_DisatnceKinBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();

        List<TreeNode> paths = findPath(root, target);

        for(int i = 0; i < paths.size(); i++) {
            TreeNode cur = paths.get(i);
            int dis = K - i;

            if(i == K) {
                res.add(cur.val);
                break;
            } else if(i > 0) {
                cur = cur.left == paths.get(i - 1) ? cur.right : cur.left;
                dis = K - i - 1;
            }
            getDistanceK(cur, dis, res);
        }
        return res;
    }

    private void getDistanceK(TreeNode root, int k, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(k == 0) {
            list.add(root.val);
        }
        k--;
        getDistanceK(root.left, k, list);
        getDistanceK(root.right, k, list);
    }

    private List<TreeNode> findPath(TreeNode root, TreeNode target) {
        if(root == null) {
            return null;
        }

        if(root == target) {
            List<TreeNode> res = new ArrayList<>();
            res.add(target);
            return res;
        }

        List<TreeNode> left = findPath(root.left, target);
        if(left != null) {
            left.add(root);
            return left;
        }
        List<TreeNode> right = findPath(root.right, target);
        if(right != null) {
            right.add(root);
            return right;
        }
        return null;
    }

}
