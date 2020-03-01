package solution200_299;

import java.util.*;

/**
 * Created by zjw on 2017/10/27.
 */
public class P207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        // 从图中移走没有前驱的课程，检查是否有新的课程没有前驱，如果有，则添加到移走的课程所在的集合(即freeCourse)
        // 如果存在环路，那么最终得到的集合的元素数目，将小于课程总数目
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

        return index == freeCourse.length;
    }

}
