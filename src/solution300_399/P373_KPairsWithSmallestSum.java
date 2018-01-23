package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2018/01/23 15:58
 * Description:
 */
public class P373_KPairsWithSmallestSum {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if(k <= 0 || nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        // {num in nums1, pos in nums2, sum}
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int num : nums1) {
            queue.add(new int[]{num, 0, num + nums2[0]});
        }

        while(k > 0 && !queue.isEmpty()) {
            k--;
            int[] pair = queue.poll();
            result.add(new int[] {pair[0], nums2[pair[1]]});
            if(pair[1] + 1 < nums2.length) {
                queue.add(new int[]{pair[0], pair[1] + 1, pair[0] + nums2[pair[1] + 1]});
            }
        }
        return result;
    }

}
