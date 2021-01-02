package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zjw on 2017/6/1.
 */
public class P56_MergeIntervals {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0)  return res;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start)    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });
        res.add(intervals.get(0));
        for(Interval ite: intervals) {
            Interval last = res.get(res.size() - 1);
            if(ite.start >= last.start && ite.start <= last.end) {
                last.end = Math.max(last.end, ite.end);
            }
            else {
                res.add(ite);
            }
        }
        return res;
    }
}
