package solution800_899;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zjw on 2018/06/24 10:34
 * Description:
 */
public class P857_MinCostToHireK {

    // from leetcode discussion
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for(int i = 0; i < n; i++) {
            workers[i][0] = (double)wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        Queue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        double res = Integer.MAX_VALUE;
        for(double[] worker: workers) {
            sum += worker[1];
            queue.offer(-(int)worker[1]);
            if(queue.size() > K) {
                sum += queue.poll();
            }
            if(queue.size() == K) {
                res = Math.min(res, worker[0] * sum);
            }
        }
        return res;
    }

}
