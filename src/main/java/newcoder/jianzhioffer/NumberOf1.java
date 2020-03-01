package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 11:28
 * Description: 二进制中1的个数
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        int res = 0;
        while(n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }

}
