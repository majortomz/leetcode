package solution300_399;

/**
 * Created by zjw on 2018/01/18 15:37
 * Description:
 */
public class P357_CountNumsWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int result = n <= 0 ? (n == 0? 1: 0) : 10;
        int count = 9;
        for(int i = 2; i <= 10 && i <= n; i++) {
            count *= (11- i);
            result += count;
        }
        return result;
    }

}
