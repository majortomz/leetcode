package solution100_199;

/**
 * Created by zjw on 2017/9/28.
 */
public class P172_FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int res = 0;

        int tmp = 1, count = 0, last = 0;

        while(tmp <= n / 5) {
            tmp *= 5;
            count++;
        }

        while(tmp >= 5) {
            res += (n / tmp - last) * count;
            last = n / tmp;
            tmp /= 5;
            count--;
        }

        return res;
    }

    public int trailingZeroes2(int n) {
        int res = 0;
        while(n >= 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
