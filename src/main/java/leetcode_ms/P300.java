package leetcode_ms;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/06 19:09
 * Description: 300. Longest Increasing Subsequence
 */
public class P300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length, size = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            int low = 0, high = size - 1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(nums[i] <= dp[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            dp[low] = nums[i];
            if(low == size) {
                size++;
            }
        }
        return size;
    }

}
