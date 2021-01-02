package solution300_399;

import java.util.Arrays;

/**
 * Created by zjw on 2017/12/1.
 */
public class P324_WiggleSort2 {

    public void wiggleSort(int[] nums) {
        int b[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(b);
        int mid = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        int k = 0, i, j;
        for(i = mid - 1, j = nums.length - 1; i >= 0 && j >= mid; i--, j--) {
            nums[k++] = b[i];
            nums[k++] = b[j];
        }
        if(i == 0) {
            nums[nums.length - 1] = b[0];
        }
    }

    // from leetcode discussion
    public void wiggleSort2(int[] nums) {
        int k = nums.length  / 2;
        int mid = findKthLargest(nums, 0, nums.length - 1, k);
        int len = nums.length;

        int left = 0, right = nums.length - 1, i = 0;
        while(i <= right) {
            if(nums[newIndex(i, len)] > mid) {
                swap(nums, newIndex(left++, len), newIndex(i++, len));
            } else if(nums[newIndex(i, len)] < mid) {
                swap(nums, newIndex(right--, len), newIndex(i, len));
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        int x = nums[end];
        int i = start;
        for(int j = start; j < end; j++) {
            if(nums[j] >= x) {
                swap(nums, i++, j);
            }
        }
        nums[end] = nums[i];
        nums[i] = x;

        if(i == k)
            return x;
        else if(i > k)
            return findKthLargest(nums, start, i - 1, k);
        else
            return findKthLargest(nums, i + 1, end, k);
    }

    public static void main(String[] args) {
        P324_WiggleSort2 ws = new P324_WiggleSort2();
        for(int i = 0; i < 7; i++) {
            int[] nums = {6, 5, 4, 7, 2, 16, 8};
            System.out.println(ws.findKthLargest(nums, 0, nums.length - 1, i));
        }
    }

}
