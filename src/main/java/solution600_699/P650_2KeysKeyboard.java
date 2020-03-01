package solution600_699;

/**
 * Created by zjw on 2017/8/1.
 */
public class P650_2KeysKeyboard {

    public int minSteps(int n) {
        int t = 0, value = 2, mid = n/2;
        if(n == 1)  return 0;
        while(value < mid && n % value != 0) {
            value++;
        }
        if(value >= mid)
            return n;
        else
            t += minSteps(n / value) + value;
            return t;
    }
}
