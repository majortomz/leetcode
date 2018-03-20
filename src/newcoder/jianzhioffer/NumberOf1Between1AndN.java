package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/07 19:20
 * Description: 求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN {

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)    return 0;
        else if(n == 1)    return 1;
        int res = 0, sum = 0;
        while(n > 0) {
            int b = n % 10;
            if(b == 0) {
                res = sum;
            } else if(b == 1) {
                res = sum + sum * res;
            } else {
                res = (b - 2) * sum + 2 * sum + res;
            }
            sum *= 11;
            n /= 10;
        }
        return res;
    }

}
