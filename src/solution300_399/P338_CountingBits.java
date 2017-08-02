package solution300_399;

/**
 * Created by zjw on 2017/8/1.
 */
public class P338_CountingBits {

    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int base = 1, next = 2;
        for(int i = 1; i <= num; i++) {
            res[i] = res[i - base] + 1;
            if(i == next - 1) {
                base = next;
                next *= 2;
            }
        }
        return res;
    }

}
