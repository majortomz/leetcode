package solution200_299;

/**
 * Created by zjw on 2017/10/12.
 */
public class P231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)  return false;
        int num = 0;
        while(n != 0) {
            if((n & 1) == 1) num++;
            if(num > 1) return false;
            n >>>= 1;
        }
        return true;
    }

    // from leetcode discussion
    public boolean isPowerOfTwo2(int n) {
        return n > 0 & (n & (n - 1)) == 0;
    }
}
