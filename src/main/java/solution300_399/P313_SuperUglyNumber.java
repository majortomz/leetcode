package solution300_399;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * Created by zjw on 2017/11/27.
 */
public class P313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n], pos = new int[1001];
        // int[] {prime, dp[cur] * prime}
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        dp[0] = 1;
        for(int i = 0; i < primes.length; i++) {
            pos[primes[i]] = 0;
            queue.add(new int[] {primes[i], primes[i]});
        }

        for(int i = 1; i < n; i++) {
            int min = queue.peek()[1];
            while(queue.peek()[1] == min) {
                int[] next = queue.poll();
                dp[i] = next[1];
                pos[next[0]]++;
                next[1] = dp[pos[next[0]]] * next[0];
                queue.add(next);
            }

        }
        return dp[n-1];
    }

    // faster than priority queue
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] dp = new int[n], pos = new int[primes.length];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int k = 0; k < primes.length; k++) {
                min = Math.min(min, dp[pos[k]] * primes[k]);
            }
            dp[i] = min;
            for(int k = 0; k < primes.length; k++) {
                if(dp[pos[k]] * primes[k] == min) {
                    pos[k]++;
                }
            }
        }
        return dp[n-1];
    }

}
