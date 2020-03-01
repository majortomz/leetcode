package leetcode_ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/08/06 19:39
 * Description:
 */
public class P56 {

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

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) {
            return list;
        }

        intervals.sort((a, b) -> (a.start - b.start));
        Interval prev = new Interval(intervals.get(0).start, intervals.get(0).end);
        list.add(prev);

        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(cur.start <= prev.end) {
                prev.end = Math.max(cur.end, prev.end);
            } else {
                prev = new Interval(cur.start, cur.end);
                list.add(prev);
            }
        }
        return list;
    }

}
