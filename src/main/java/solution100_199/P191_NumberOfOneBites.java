package solution100_199;

/**
 * Created by zjw on 2017/10/11.
 */
public class P191_NumberOfOneBites {

    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += (n & 1);
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-1));
    }
}
