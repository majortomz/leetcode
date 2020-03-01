package solution200_299;

import java.util.HashSet;

/**
 * Created by zjw on 2017/6/21 15:09.
 */
public class P202_HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            int next = 0, mod;
            while(n > 0) {
                mod = n % 10;
                next += (mod * mod);
                n /= 10;
            }
            if(next == 1)
                return true;
            n = next;
        }
        return false;
    }
}
