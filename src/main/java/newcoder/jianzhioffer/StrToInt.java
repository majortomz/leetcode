package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 23:38
 * Description:
 */
public class StrToInt {

    public int StrToInt(String str) {
        if(str == null || str.length() == 0)    return 0;
        char[] digits = str.toCharArray();
        int res = 0, flag = 1;
        boolean hasDigit = false;
        if(digits[0] == '-') {
            flag = -1;
        } else if(digits[0] >= '0' && digits[0] <= '9') {
            res = digits[0] - '0';
            hasDigit = true;
        } else if(digits[0] != '+') {
            return 0;
        }
        for(int i = 1; i < digits.length; i++) {
            if(digits[i] >= '0' && digits[i] <= '9') {
                    hasDigit = true;
                res = res * 10 + flag * (digits[i] - '0');
            } else {
                return 0;
            }
        }
        if(hasDigit)    return res;
        else return 0;
    }

    public static void main(String[] args) {
        StrToInt sti = new StrToInt();
        System.out.println(sti.StrToInt("+123"));
    }

}
