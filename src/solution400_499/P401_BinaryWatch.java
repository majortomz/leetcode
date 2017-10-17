package solution400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/10/12.
 */
public class P401_BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[][] hour_map = {{0}, {1, 2, 4, 8}, {3, 5, 6, 9, 10}, {7, 11}};
        int[] minutes = {1, 2, 4, 8, 16, 32};
        for(int hour = 0; hour <= 3 && hour <= num; hour++) {
            int minBits = num - hour;
            if(minBits > 6) continue;
            getMinutesList(res, minutes, hour_map[hour], 0, 0, 0, minBits);
        }
        return res;
    }

    public void getMinutesList(List<String> res, int[] minutes, int[] hours, int sum, int start, int size, int total) {
        if(sum >= 60 || size > total)   return;
        if(size == total) {
            for(int hour : hours) {
                res.add(String.format("%d:%02d", hour, sum));
            }
            return;
        }

        for(int i = start; i < minutes.length; i++) {
            getMinutesList(res, minutes, hours, sum + minutes[i], i + 1, size + 1, total);
        }
    }

    // leetcode discussion
    public List<String> readBinaryWatch2(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }

}
