package solution100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/5/19.
 */
public class P119_PascalTriangle2 {

    // using array is more efficient
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0)   return res;
        res.add(1);
        if(rowIndex == 0)   return res;
        res.add(1);
        if(rowIndex == 1)   return res;
        for(int i=2; i<=rowIndex; i++) {
            int prev = 1;
            for(int j=1; j < i; j++)
            {
                int tmp = res.get(j);
                res.set(j, res.get(j) + prev);
                prev = tmp;
            }
            res.add(1);
        }
        return res;
    }
}
