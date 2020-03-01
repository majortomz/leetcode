package solution800_899;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2018/05/27 10:01
 * Description:
 */
public class P842_SplitArrayToFibonacciSeq {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() == 0) {
            return res;
        }
        dfs(S, 0, res);
        return res;
    }

    public boolean dfs(String S, int start, List<Integer> path) {
        if(start >= S.length()) {
            return path.size() >= 3;
        }

        int prev = -1;
        for(int i = start; i < S.length() && i - start < 32; i++) {
            // 避免开头是0
            if(prev == 0) {
                break;
            }
            // 使用long避免超过int最大值
            long cur = Long.valueOf(S.substring(start, i + 1));
            if(cur > Integer.MAX_VALUE)  {
                break;
            }
            prev = (int)cur;
            if(path.size() < 2 || cur - path.get(path.size() - 1) == path.get(path.size() - 2)) {
                path.add((int)cur);
                if(dfs(S, i + 1, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

}
