package solution400_499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zjw on 2018/01/31 11:22
 * Description:
 */
public class P436_FindRightInterval {

    class Interval {
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

    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        Arrays.sort(intervals, (x, y) -> (x.start - y.start));

        int[] res = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++) {
            Interval cur = intervals[i];
            res[map.get(cur.start)] = -1;
            int lt = i + 1, rt = intervals.length - 1;
            while(lt <= rt) {
                int mid = lt + (rt - lt) / 2;
                if(intervals[mid].start >= cur.end && (mid == lt || intervals[mid - 1].start < cur.end)) {
                    res[map.get(cur.start)] = map.get(intervals[mid].start);
                    break;
                }
                if(intervals[mid].start < cur.end) {
                    lt = mid + 1;
                } else {
                    rt = mid;
                }
            }
        }
        return res;
    }

    public int[] findRightInterval2(Interval[] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i].start, i);
        }

        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i].end);
            res[i] = entry == null ? -1 : entry.getValue();
        }
        return res;
    }
}
