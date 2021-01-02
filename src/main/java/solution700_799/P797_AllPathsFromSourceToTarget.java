package solution700_799;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/05/28 13:59
 * Description:
 */
public class P797_AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if(graph == null || graph.length == 0) {
            return res;
        }

        dfs(graph, res, new ArrayList<>(), 0, graph.length - 1);

        return res;
    }

    public void dfs(int[][] graph, List<List<Integer>> res, List<Integer> path, int index, int target) {
        path.add(index);
        if(target == index) {
            res.add(new ArrayList<>(path));
        } else {
            for(int next: graph[index]) {
                dfs(graph, res, path, next, target);
            }
        }
        path.remove(path.size() - 1);
    }


}
