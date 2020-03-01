package solution200_299;

/**
 * Created by zjw on 2017/10/31.
 */
public class P258_AddDigits {

    // solution 1
    public int addDigits(int num) {
        while(num >= 10) {
            int temp = 0;
            while(num > 0) {
                temp += (num % 10);
                num /= 10;
            }
            num = temp;
        }
        return num;
    }

    class Solution2 extends P258_AddDigits {

        /*from leetcode discussion
        dr(n) = 0 if n == 0
        dr(n) = (b-1) if n != 0 and n % (b-1) == 0
        dr(n) = n mod (b-1) if n % (b-1) != 0

        or

        dr(n) = 1 + (n - 1) % 9
        */
        @Override
        public int addDigits(int num) {
            if(num < 10)    return num;
            num %= 9;
            if(num == 0)    return 9;
            else    return num;
        }
    }

}

