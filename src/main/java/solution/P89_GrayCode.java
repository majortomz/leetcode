package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/9/23.
 */
public class P89_GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n < 0)  return res;
        res.add(0);
        for(int i = 1; i <= n; i++) {
            int pos = 1 << (i - 1);
            for(int m = pos - 1; m >= 0 ; m--) {
                res.add(res.get(m) | pos);
            }
        }
        return res;
    }

}
