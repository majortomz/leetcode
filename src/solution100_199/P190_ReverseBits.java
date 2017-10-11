package solution100_199;

/**
 * Created by zjw on 2017/10/11.
 */
public class P190_ReverseBits {

    public static int reverseBits(int n) {
        int res = 0;
        for(int i = 1; i <= 32; i++) {
            res = (res << 1) | (n & 1);
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

}
