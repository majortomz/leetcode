package solution400_499;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by zjw on 2018/01/31 10:44
 * Description:
 */
public class P435_NonOverlappingIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (x, y) -> (x.start == y.start ? x.end - y.end : x.start - y.start));
        int count = 0, prev = 0;
        for(int i = 1; i < intervals.length; i++) {
            Interval inter = intervals[i];
            if(intervals[prev].start == inter.start) {
                // [1, 1] [1, 2]
                count++;
            } else if(intervals[prev].end <= inter.start) {
                // [1, 2] [3, 9]
                prev = i;
            } else if(intervals[prev].end >= inter.end){
                // [1, 5] [2, 4]
                prev = i;
                count++;
            } else {
                // [1, 5] [2, 7]
                count++;
            }
        }
        return count;
    }

    public int eraseOverlapIntervals2(Interval[] intervals) {
        // first sort by end
        Arrays.sort(intervals, (x, y) -> (x.end == y.end ? x.start - y.start : x.end - y.end));
        int count = 0, end = Integer.MIN_VALUE;
        for(Interval interval : intervals) {
            if(interval.start >= end) end = interval.end;
            else    count++;
        }
        return count;
    }
}
