package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/9/23.
 */
public class P77_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(res, path, n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> path, int n, int k, int start) {
        if(path.size() == k)   {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++) {
            path.add(i);
            helper(res, path, n, k, i+1);
            path.remove(path.size() - 1);
        }
    }

}
