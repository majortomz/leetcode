package solution600_699;

/**
 * Created by zjw on 2017/10/11.
 */
public class P693_BinaryNumbereWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int last = 1 & n;
        n = n >>> 1;
        while(n != 0) {
            int now = 1 & n;
            if(now == last) return  false;
            last = now;
            n = n >>> 1;
        }
        return true;
    }

    // leetcode discussion
    // check if (n + (n >> 1) + 1) is power of 2
    public boolean hasAlternatingBits2(int n) {
        int t = n >> 1;
        n += t;
        t += n;
        return (t & n) == 0;
    }

}
