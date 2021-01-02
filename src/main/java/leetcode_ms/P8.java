package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 19:54
 * Description: String to integer
 */
public class P8 {

    public int myAtoi(String str) {
        if(str == null || str.trim().length() == 0) {
            return 0;
        }

        char[] digits = str.trim().toCharArray();
        int flag = 1, i = 0;
        long res = 0;
        if(digits[0] == '+') {
            i++;
        } else if(digits[0] == '-') {
            i++;
            flag = -1;
        } else if(('0' <= digits[0] && digits[0] <= '9')) {
            flag = 1;
        }

        while(i < digits.length && Character.isDigit(digits[i])) {
            res = res * 10 + flag * (digits[i] - '0');
            if(res <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if(res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            i++;
        }

        return (int)res;
    }

}
