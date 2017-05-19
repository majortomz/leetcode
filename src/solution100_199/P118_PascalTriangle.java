package solution100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/5/19.
 */
public class P118_PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> first = new ArrayList<>(), prev = first;
        first.add(1);
        res.add(first);
        // one row
        if (numRows == 1) return res;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(prev.get(0));
            next.add(prev.get(prev.size() - 1));
            for (int j = 1; j < prev.size(); j++) {
                int len = next.size();
               next.add(len - 1, prev.get(j) + prev.get(j - 1));
            }
            res.add(next);
            prev = next;
        }
        return res;
    }
}
