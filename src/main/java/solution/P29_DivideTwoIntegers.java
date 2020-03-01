package solution;

/**
 * Created by zjw on 2017/9/21.
 */
public class P29_DivideTwoIntegers {

    // special case: [-2147483648, 1] [-2147483648, -1], [2147483647, 1] [1, 0]
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))    return Integer.MAX_VALUE;

        int flag = 1, temp;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            flag = -1;

        //convert dividend and divisor to negative
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        // final result
        int res = 0;

        while(dividend <= divisor) {
            temp = divisor;
            int tempRes = 1;
            while(dividend - temp <= temp) {
                tempRes = tempRes << 1;
                temp = temp << 1;
            }
            res += tempRes;
            dividend -= temp;
        }
        return flag * res;
    }
}
