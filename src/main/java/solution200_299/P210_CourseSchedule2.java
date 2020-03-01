package solution200_299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjw on 2017/10/27.
 */
public class P210_CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int counts[] = new int[numCourses], freeCourse[] = new int[numCourses];
        int index = 0;

        // represent whole map with linked list
        for(int[] pre : prerequisites) {
            if(!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            counts[pre[0]]++;
            map.get(pre[1]).add(pre[0]);
        }

        // 获得所有没有前驱的课程
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] == 0) {
                freeCourse[index++] = i;
            }
        }

        int curIndex = 0;
        while(curIndex < index) {
            if(map.get(freeCourse[curIndex]) != null) {
                for(Integer post : map.get(freeCourse[curIndex])) {
                    if(--counts[post] == 0) {
                        freeCourse[index++] = post;
                    }
                }
            }
            curIndex++;
        }

        if(index == freeCourse.length)
            return freeCourse;
        else
            return new int[0];
    }

}
