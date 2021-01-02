package toutiao;

import java.util.Arrays;
import java.util.Scanner;

public class Solution5 {


    private static int maxRes = 0;
    private static int maxHeight = 0;
    private static int h = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        h = sc.nextInt();

        int[] nums = new int[n];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }

        Arrays.sort(nums);
        maxRes = 0;
        maxHeight = max + h;
        int[][] dp = new int[max + h + 1][k + 1];
        helper(dp, nums, 0, k);
        System.out.println(maxRes);
    }

    public static void helper(int[][] dp, int[] nums, int height, int k) {
        if(k <= 0 || dp[height][k] > 0)  return;

        int index = Arrays.binarySearch(nums, height - h);
        if(index < 0) {
            index = -index - 1;
        }
        for(int i = index; i < nums.length; i++) {
            int nextHeight = nums[i] >= height ? nums[i] + nums[i] - height : nums[i] - (height - nums[i]);
            if(nextHeight < 0 || nextHeight > maxHeight)    continue;
            maxRes = Math.max(maxRes, nextHeight);
            helper(dp, nums, nextHeight, k - 1);
        }
    }



}
