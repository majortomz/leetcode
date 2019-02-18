package leetcode_ms;

/**
 * Created by zjw on 2018/08/07 10:30
 * Description:
 */
public class P650 {

    public int minSteps(int n) {
        if(n == 1) {
            return 0;
        }

        int value = 2, mid = (int)(Math.sqrt(n));
        while(value <= mid && n % value != 0) {
            value++;
        }

        if(value > mid) {
            return n;
        } else {
            return value + minSteps(n / value);
        }

    }

}
