package solution300_399;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zjw on 2018/01/23 17:13
 * Description:
 */
public class P378_KthSmallestEleInMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            queue.add(new int[] {i, 0, matrix[i][0]});
        }
        int result = 0;
        while(k > 0 && !queue.isEmpty()) {
            k--;
            int[] item = queue.poll();
            if(k == 0) {
                result = item[2];
                break;
            }
            if(item[1] + 1 < n) {
                item[1]++;
                item[2] = matrix[item[0]][item[1]];
                queue.add(item);
            }
        }
        return result;
    }

}
