package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/19 10:14
 * Description: Sum of Subsequence Widths
 */
public class P891_SumOfSubsequenceWidths {

    int mod = 1_000_000_007;

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);

        long n = A.length;
        long count = 1, res = 0, sub = 0;

        for(int i = 1; i < n; i++) {
            sub += (A[i] - A[i - 1]) * count;
            sub %= mod;
            res = res * 2 + sub;
            res %= mod;
            count = count * 2 + 1;
            count %= mod;
        }
        return (int)(res % mod);
    }

    public static void main(String[] args) {
        P891_SumOfSubsequenceWidths sos = new P891_SumOfSubsequenceWidths();
        System.out.println(sos.sumSubseqWidths(new int[]{3, 2, 1, 4}));
    }
}
