package solution800_899;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zjw on 2018/07/01 10:35
 * Description:
 */
public class P862_ShortestSubarray {

    // TLE
    public static int shortestSubarray(int[] A, int K) {
        int[] sums = new int[A.length], sumK = new int[A.length], lengths = new int[A.length], res = new int[A.length];

        sums[0] = A[0];     // 到当前坐标的子数组和 >= k的最小长度
        lengths[0] = 1;     // 到当前坐标的最大和的子数组长度
        sumK[0] = A[0];
        res[0] = sums[0] >= K ? 1 : -1;  // 当前坐标结尾的子数组和 >= k 的长度

        int minLength = res[0];

        for(int i = 1; i < A.length; i++) {
            sums[i] = Math.max(sums[i - 1] + A[i], A[i]);
            lengths[i] = sums[i] == A[i] ? 1: lengths[i - 1] + 1;

            if(sums[i] < K) {
                res[i] = -1;
                continue;
            }

            int k = res[i - 1] == -1 ? i - lengths[i] + 1 : i - 1 - res[i - 1] + 1;
            sumK[i] = res[i - 1] == -1 ? sums[i] : sumK[i - 1] + A[i];
            res[i] = i - k + 1;
            int tmpSum = 0, tmpSumK = sumK[i];
            while(k <= i) {
                tmpSum += A[k];
                if(sumK[i] - tmpSum >= K) {
                    res[i] = i - k;
                    tmpSumK = sumK[i] - tmpSum;
                }
                k++;
            }
            sumK[i] = tmpSumK;
            minLength = minLength == -1 ? res[i] : Math.min(res[i], minLength);
        }
        return minLength;
    }

    // from leetcode discussion
    public int shortestSubarray2(int[] A, int K) {
        int N = A.length;
        int[] p = new int[N + 1];

        for(int i = 0; i < N; i++) {
            p[i + 1] = p[i] + A[i];
        }

        int res = N + 1;
        Deque<Integer> queue = new LinkedList<>();

        for(int y = 0; y < p.length; y++) {
            while(!queue.isEmpty() && p[y] <= p[queue.getLast()]) {
                queue.removeLast();
            }

            while(!queue.isEmpty() && p[y] >= p[queue.getFirst()] + K) {
                res = Math.min(res, y - queue.removeFirst());
            }

            queue.addLast(y);
        }

        return res < N + 1 ? res : -1;
    }

    public static void main(String[] args) {
        shortestSubarray(new int[]{2, -1, 2,2}, 3);
    }

}
