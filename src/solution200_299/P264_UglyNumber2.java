package solution200_299;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by zjw on 2017/9/19.
 */
public class P264_UglyNumber2 {

    // from leetcode discussion
    public int nthUglyNumber(int n) {
        if(n <= 0)  return 0;

        if (n == 1) return 1;

        // p2 : record the smallest number which has not been multiplied by 2
        // so as p3 by 3, and p5 by 5
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n; i++) {
            // pay attention to 6 = 2*3 ; 6 = 3*2
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2)
                p2++;
            if(dp[i] == dp[p3] * 3)
                p3++;
            if(dp[i] == dp[p5] * 5)
                p5++;
        }

        return dp[n-1];}
}
