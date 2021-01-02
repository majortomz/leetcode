package solution200_299;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/6/10.
 */
public class P216_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(k , n, 1, res, tmp);
        return res;
    }

    public void helper(int k , int n, int start, List<List<Integer>> res, List<Integer> tmp) {
        if(k <= 0 || n <=0)
            return;
        for(int i = start; i <= 9 - k + 1; i++) {
            tmp.add(i);
            if(k == 1 && n == i)
                res.add(new ArrayList<>(tmp));
            else
                helper(k-1, n-i, i+1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
