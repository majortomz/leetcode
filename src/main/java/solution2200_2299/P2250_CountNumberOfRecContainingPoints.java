package solution2200_2299;

import java.util.*;

/**
 * Created by zjw on 2022/04/30 16:50
 * Description:
 */
public class P2250_CountNumberOfRecContainingPoints {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        };
        Arrays.sort(rectangles, comparator);
        List<Integer> xIdx = new ArrayList<>();
        int lastY = rectangles[0][1];
        for (int i = 0; i < rectangles.length; i++) {
            int[] rec = rectangles[i];
            if (rec[1] != lastY) {
                lastY = rec[1];
                xIdx.add(i);
            }
        }
        xIdx.add(rectangles.length);
        int[] counter = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int start = 0;
            for (int end : xIdx) {
                if (rectangles[start][1] < points[i][1]) {
                    start = end;
                    continue;
                }

                int idx = binarySearch(rectangles, start, end - 1, points[i][0]);
                counter[i] += (end - 1 - idx);
                start = end;
            }
        }
        return counter;
    }

    private int binarySearch(int[][] rectangles, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (rectangles[mid][0] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        P2250_CountNumberOfRecContainingPoints countNumberOfRecContainingPoints = new P2250_CountNumberOfRecContainingPoints();
        countNumberOfRecContainingPoints.countRectangles(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2,5}},
                new int[][]{new int[]{2, 1}, new int[]{1 , 4}});
    }
}
