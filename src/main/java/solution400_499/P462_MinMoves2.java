package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2018/02/03 12:35
 * Description:
 */
public class P462_MinMoves2 {

    // from leetcode discussion: meeting problem
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += (nums[j] - nums[i]);
            i++;
            j--;
        }
        return count;
    }

    class Solution2 {
        // Solution 2: from leetcode: quick select
        public int minMoves2(int[] nums) {
            int mid = quickSelect(nums, nums.length / 2 + 1, 0, nums.length - 1);
            int count = 0;
            for (int num : nums) {
                count += Math.abs(num - mid);
            }
            return count;
        }

        private int quickSelect(int[] nums, int k, int lt, int rt) {
            int l = lt, r = rt, pivot = nums[l + (r - l) / 2];
            while (l <= r) {
                while (nums[l] < pivot) l++;
                while (nums[r] > pivot) r--;
                if (l >= r) break;
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
            if (l - lt + 1 > k) {
                return quickSelect(nums, k, lt, l - 1);
            }
            if (l - lt + 1 == k && l == r) return nums[l];
            return quickSelect(nums, k - (r - lt + 1), r + 1, rt);
        }
    }

}
