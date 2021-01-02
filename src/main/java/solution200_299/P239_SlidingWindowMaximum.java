package solution200_299;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by zjw on 2018/05/22 10:12
 * Description:
 */
public class P239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i = 0; i < k; i++) {
            queue.offer(new int[]{i, nums[i]});
        }
        int[] res = new int[nums.length - k + 1];
        for(int i = k; i < nums.length; i++) {
            int[] top = queue.peek();
            res[i - k] = top[1];
            // 排除过期掉的
            while(top != null && top[0] <= i - k) {
                queue.poll();
                top = queue.peek();
            }
            queue.offer(new int[]{i, nums[i]});
        }
        res[nums.length - k] = queue.peek()[1];
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
        }

        for(int i = k; i < nums.length; i++) {
            res[i - k] = nums[queue.peek()];
            // 删除比当前数要小的
            while(!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            // 移除过期的
            while(!queue.isEmpty() && queue.peek() <= i - k) {
                queue.removeFirst();
            }
            queue.offer(i);
        }
        res[nums.length - k] = nums[queue.peek()];
        return res;
    }

}
