package leetcode_ms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zjw on 2018/08/07 9:59
 * Description:
 */
public class P55 {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 1) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur + nums[cur] >= nums.length - 1) {
                return true;
            }

            for(int i = cur + 1; i <= cur + nums[cur]; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return false;
    }

    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 1) {
            return true;
        }

        int farReach = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > farReach) {
                break;
            }
            farReach = Math.max(farReach, i + nums[i]);
            if(farReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
