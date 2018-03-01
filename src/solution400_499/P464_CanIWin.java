package solution400_499;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2018/02/03 14:12
 * Description:
 */
public class P464_CanIWin {

    // can be solved using brute-force, the key is to avoid repeatedly solving sub-problems
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0)  return true;
        if(desiredTotal > (maxChoosableInteger + 1) * maxChoosableInteger / 2) return false;
        return helper(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    private boolean helper(int maxInteger, int total, int state, Map<Integer, Boolean> map) {
        if(map.containsKey(state))  return map.get(state);
        for(int i = 0; i < maxInteger; i++) {
            if((1 << i & state) == 0) {
                if(total <= i + 1 || !helper(maxInteger, total - (i + 1), (1 << i | state), map)) {
                    map.put(state, true);
                    return true;
                }
            }
        }
        map.put(state, false);
        return false;
    }

}
