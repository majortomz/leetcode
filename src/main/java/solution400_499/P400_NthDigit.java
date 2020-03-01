package solution400_499;

/**
 * Created by zjw on 2018/01/26 15:16
 * Description:
 */
public class P400_NthDigit {

    public int findNthDigit(int n) {
        int count = 9, digits = 1;
        while(n > (long)(digits - 1) * count) {
            n -= digits * count;
            count *= 10;
            digits += 1;
        }
        int num = (int)Math.pow(10, digits - 1) + (n - 1) / digits;
        n = digits - (n - 1) % digits;
        while(n > 1) {
            num /= 10;
            n--;
        }
        return num % 10;
    }

}
