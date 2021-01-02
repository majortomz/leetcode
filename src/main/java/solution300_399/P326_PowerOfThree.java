package solution300_399;

/**
 * Created by zjw on 2017/11/30.
 */
public class P326_PowerOfThree {

    public boolean isPowerOfThree(int n) {
        while(n > 1) {
            if(n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }

}
