package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/07 19:20
 * Description: 求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN {

    public static int NumberOf1Between1AndN_Solution(int n) {

        if(n <= 0)    return 0;
        else if(n == 1)    return 1;
        int b = n % 10;
        n /= 10;
        int res = b >= 1 ? 1 : 0, tmpRes = 1, count = 10, tmpCount = b;
        int bit = 1;
        while(n > 0) {
            b = n % 10;
            if (b == 1) {
                res = tmpRes + res + tmpCount + 1;
            } else if(b > 1) {
                res = b * tmpRes + count + res;
            }
            tmpRes = tmpRes * 10 + count;
            tmpCount = (int)Math.pow(10, bit++) * b + tmpCount;
            count *= 10;
            n /= 10;
            System.out.printf("%d %d %d %d\n", res, tmpRes, count, tmpCount);
        }
        return res;

    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution(21345);
    }

}
