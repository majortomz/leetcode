package solution800_899;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zjw on 2018/09/03 19:20
 * Description:
 */
public class P898_BitwiseOr {

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(), cur = new HashSet<>();
        for(int a: A) {
            Set<Integer> cur2 = new HashSet<>();
            for(int j: cur) {
                cur2.add(j | a);
            }
            cur2.add(a);
            res.addAll(cur2);
            cur = cur2;
        }
        return res.size();
    }

}
