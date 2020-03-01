package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by zjw on 2018/04/18 10:45
 * Description:
 */
public class P45_JumpGame2 {

    // BFS, leetcode discussion
    public int jump(int[] nums) {
        int step = 0, curEnd = 0, curFarthest = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if(i == curEnd) {
                curEnd = curFarthest;
                step++;
            }
        }
        return step;
    }

}
