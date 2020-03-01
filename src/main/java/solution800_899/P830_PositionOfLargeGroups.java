package solution800_899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/05/06 9:31
 * Description:
 */
public class P830_PositionOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if(S == null || S.length() == 0) {
            return res;
        }
        char c = S.charAt(0);
        int prev = 0;
        for(int i = 1; i < S.length(); i++) {
            if(S.charAt(i) != c) {
                if(i - prev >= 3) {
                    res.add(Arrays.asList(prev, i - 1));
                }
                prev = i;
                c = S.charAt(i);
            }
        }
        if(S.length() - prev >= 3) {
            res.add(Arrays.asList(prev, S.length() - 1));
        }
        return res;
    }

}
