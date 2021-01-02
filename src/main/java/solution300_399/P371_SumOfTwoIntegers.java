package solution300_399;

/**
 * Created by zjw on 2017/10/11.
 */
public class P371_SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int res = 0, c = 0;
        for(int i = 0; i < 32; i++) {
            int ta = (a >> i) & 1, tb = (b >> i) & 1;
            int sum = ta ^ tb ^ c;
            c = (ta & tb) | (ta & c) | (tb & c);
            res = res | (sum << i);
        }
        return res;
    }

    public int getSum2(int a, int b) {
        if(a == 0)  return b;
        if(b == 0)  return a;

        while(b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }

}
