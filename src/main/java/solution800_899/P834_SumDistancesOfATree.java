package solution800_899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/05/13 10:19
 * Description:
 */
public class P834_SumDistancesOfATree {

    class TreeNode {
        int id;
        int sum = 0, childsum = 0, parentSum = 0;
        int childCount = 0, parentCount = 0;

        public TreeNode(int id) {
            this.id = id;
        }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {


        List<TreeNode> nodes = new ArrayList<>();
        List<List<TreeNode>> map = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new TreeNode(i));
            map.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(nodes.get(edge[1]));
            map.get(edge[1]).add(nodes.get(edge[0]));
        }

        // 后续遍历
        postOrder(nodes, map, 0, new boolean[N]);

        // 先序遍历
        preOrder(nodes, map, 0, null, new boolean[N]);

        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = nodes.get(i).sum;
        }

        System.out.println(Arrays.toString(res));
        return res;
    }

    private void postOrder(List<TreeNode> nodes, List<List<TreeNode>> map, int id, boolean[] visited) {
        if (map.get(id).size() == 0) {
            return;
        }

        List<TreeNode> childs = map.get(id);
        TreeNode node = nodes.get(id);
        visited[id] = true;
        for (int i = 0; i < childs.size(); i++) {
            TreeNode child = childs.get(i);
            if (visited[child.id]) continue;
            postOrder(nodes, map, child.id, visited);
            node.childsum += (child.childsum + child.childCount + 1);
            node.childCount += (child.childCount + 1);
        }

    }

    private void preOrder(List<TreeNode> nodes, List<List<TreeNode>> map, int id, TreeNode parent, boolean[] visited) {

        if (visited[id]) {
            return;
        }

        visited[id] = true;
        List<TreeNode> childs = map.get(id);
        TreeNode node = nodes.get(id);

        // 兄弟节点的和
        if (parent != null) {
            node.parentCount = parent.parentCount + 1 + (parent.childCount - node.childCount - 1);
            node.parentSum = (parent.parentSum + parent.parentCount + 1) + (parent.childsum - node.childsum - node.childCount - 1
                    + parent.childCount - node.childCount - 1);
        }
        node.sum = node.childsum + node.parentSum;

        for (TreeNode child : childs) {
            if (!visited[child.id]) {
                preOrder(nodes, map, child.id, node, visited);
            }
        }

    }


}
