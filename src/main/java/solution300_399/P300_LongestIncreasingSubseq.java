package solution300_399;

/**
 * Created by zjw on 2017/11/16.
 */
public class P300_LongestIncreasingSubseq {

    // O(n^2)
    public int lengthOfLIS(int[] nums) {
        int length = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            length = Math.max(dp[i], length);
        }
        return length;
    }

    // O(n*log(n)) from leetcode discussion
    public int lengthOfLIS2(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;
        for(int num : nums) {
            int lt = 0, rt = size;
            while(lt < rt) {
                int mid = lt + (rt - lt) / 2;
                if(num <= tail[mid]) {
                    rt = mid;
                } else {
                    lt = mid + 1;
                }
            }
            tail[lt] = num;
            if(lt == size)  size++;
        }
        return size;
    }

    public int lengthOfLIS3(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int[] dp = new int[nums.length];
        int size = 0;
        for(int i = 0; i < nums.length; i++) {

            int lt = 0, rt = size - 1;
            while(lt <= rt) {
                int mid = (rt - lt) / 2 + lt;
                if(nums[i] <= dp[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            dp[lt] = nums[i];
            if(lt == size)  size++;
        }
        return size;
    }

}
