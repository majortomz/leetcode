package solution800_899;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zjw on 2018/08/01 20:19
 * Description: Length of Longest Fibonacci Subsequence
 */
public class P873_LengthOfLongestFibSeq {

    // brute force
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int y = A[j], z = A[i] + A[j];
                int len = 2;
                while (set.contains(z)) {
                    len++;
                    res = Math.max(len, res);

                    int tmp = z;
                    z = y + z;
                    y = tmp;
                }
            }
        }
        return res;
    }

    public int lenLongestFibSubseq2(int[] A) {
        if(A == null || A.length < 3) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        int[][] dp = new int[n][n];  // dp[i][j] represents longest FibSubseq ended with A[i] and A[j]
        for(int i = 0; i < n; i++) {
            map.put(A[i], i);
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
            }
        }

        int res = 0;
        for(int j = 2; j < n; j++) {
            for(int i = 0; i < j; i++) {
                int prev = A[j] - A[i];
                if(prev >= A[i]) {
                    continue;
                }
                if(map.containsKey(prev)) {
                    dp[i][j] = Math.max(dp[i][j], dp[map.get(prev)][i] + 1);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res < 3 ? 0: res;
    }

}
