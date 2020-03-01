package solution;

import java.util.Arrays;

/**
 * Created by zjw on 2017/5/16.
 */
public class P66_PlusOne {

    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        digits[digits.length - 1] += 1;
        for (int i = digits.length -1; i >= 0; i--) {
            res[i] = (res[i+1] + digits[i]) / 10;
            res[i + 1] = (res[i+1] + digits[i]) % 10;
        }
        if(res[0] == 0)
            return Arrays.copyOfRange(res, 1, res.length);
        else
            return res;
    }
}
