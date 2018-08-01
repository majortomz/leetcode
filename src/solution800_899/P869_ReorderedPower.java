package solution800_899;

/**
 * Created by zjw on 2018/07/15 9:42
 * Description:
 */
public class P869_ReorderedPower {

    static int[][] aims = new int[31][10];

    static {
        for (int i = 0; i < 31; i++) {
            int n = 2 << i;
            while (n > 0) {
                aims[i][n % 10]++;
                n /= 10;
            }
        }
    }


    public boolean reorderedPowerOf2(int N) {
        if(N == 1) {
            return true;
        }

        int[] cur = new int[10];
        while (N > 0) {
            cur[N % 10]++;
            N /= 10;
        }

        for(int i = 0; i < 31; i++) {
            boolean match = true;
            for (int j = 0; j < 10; j++) {
                if (cur[j] != aims[i][j]) {
                    match = false;
                    break;
                }
            }
            if(match) {
                return true;
            }
        }

        return false;
    }

    // reordered power of 2
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(46));
    }
}
