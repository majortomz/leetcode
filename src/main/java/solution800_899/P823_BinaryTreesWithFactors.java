package solution800_899;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2018/04/22 10:24
 * Description:
 */
public class P823_BinaryTreesWithFactors {

    private static final int MOD = 1_000_000_007;

    public static int numFactoredBinaryTrees(int[] A) {
        if(A == null || A.length == 0)  return 0;
        Arrays.sort(A);
        Map<Integer, Integer> cache = new HashMap<>();
        int res = 0;

        for(int i = 0; i < A.length; i++) {
            int count = 1, mid = A[i] / 2;
            for(int j = 0; j < i && A[j] <= mid; j++) {
                if(A[i] % A[j] == 0) {
                    long left = cache.getOrDefault(A[j], 0), right = cache.getOrDefault(A[i] / A[j], 0);
                    count += (left * right % MOD);
//                    System.out.println(A[i] + " " + A[j] + " " + count);
                    if(count >= MOD) {
                        count %= MOD;
                    }
                }
            }
            cache.put(A[i], count);
            res = (res + count) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[]{2, 4}));
    }
}
