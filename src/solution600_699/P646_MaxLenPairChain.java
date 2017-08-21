package solution600_699;

import java.util.Arrays;

/**
 * Created by zjw on 2017/8/21.
 */
public class P646_MaxLenPairChain {

    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0)  return 0;
        Arrays.sort(pairs, (x, y) -> (x[1] - y[1]));
        int last = pairs[0][1], res = 1;
        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > last) {
                res++;
                last = pairs[i][1];
            }
        }
        return res;
    }
}
