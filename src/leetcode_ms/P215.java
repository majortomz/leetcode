package leetcode_ms;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/05 11:12
 * Description:
 */
public class P215 {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        k = nums.length - k;
        int low = 0, high = nums.length - 1, res = 0;
        while(low <= high) {
            res = pivot(nums, low, high);
            if(res == k) {
                return nums[res];
            } else if(k < res) {
                high = res - 1;
            } else {
                low = res + 1;
            }
        }

        return nums[k];
    }

    private int pivot(int[] nums, int low, int high) {
        int x = nums[high];
        int i = low;
        while(low < high) {
            if(nums[low] < x) {
                int tmp = nums[i];
                nums[i] = nums[low];
                nums[low] = tmp;
                i++;
            }
            low++;
        }
        nums[high] = nums[i];
        nums[i] = x;
        return i;
    }


    public static void main(String[] args) {
        P215 p215 = new P215();
        for(int k = 1; k <= 10; k++) {
            int[] test = {5, 4, 3, 10, 2, 64, 532, 5, 17, 99};
            System.out.println(p215.findKthLargest(test, k));
        }
    }

}
