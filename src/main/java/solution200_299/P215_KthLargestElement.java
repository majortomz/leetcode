package solution200_299;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Created by zjw on 2017/10/27.
 */
public class P215_KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums)
            queue.add(num);
        for(int i = 1; i < k; i++)
            queue.poll();
        return queue.poll();
    }

}

class Solution2 extends P215_KthLargestElement {

    int heapSize = 0;

    @Override
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        for(int i = k; i > 1; i--) {
            int tmp = nums[0];
            nums[0] = nums[heapSize - 1];
            nums[heapSize - 1] = tmp;
            heapSize--;
            maxHeapify(nums, 0);
        }
        return nums[0];
    }

    public void buildHeap(int[] nums) {
        heapSize = nums.length;
        for(int i = nums.length/2; i >= 0; i--)
            maxHeapify(nums, i);
    }

    public void maxHeapify(int[] nums, int pos) {
        int left = pos * 2 + 1, right = pos * 2 + 2;
        int largest = nums[pos], next = 0;

        if(left < heapSize && nums[pos] > largest) {
            largest = nums[left];
            next = left;
        }
        if(right < heapSize && nums[right] > largest) {
            largest = nums[right];
            next = right;
        }

        if(largest != nums[pos]) {
            nums[next] = nums[pos];
            nums[pos] = largest;
            maxHeapify(nums, next);
        }
    }


}
