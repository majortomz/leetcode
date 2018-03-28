package solution800_899;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zjw on 2018/03/25 10:02
 * Description:
 */
public class P805_SplitArrayWithSameAverage {

    static class SolutionA {
        private double sum = 0;
        private int count = 0;

        public boolean splitArraySameAverage(int[] A) {
            if(A == null || A.length <= 1)  return false;

            int sum = sum(A), len = A.length;
            if(sum == 0)    return true;

            for(int sumB = 1; sumB < sum; sumB++) {
                if(len * sumB % sum != 0)   continue;
                int count = len * sumB / sum;
                if(dfs(A, sumB, 0, count))
                    return true;
            }

            return false;
        }

        private boolean dfs(int[] nums, int target, int start,  int n) {
            if(start >= nums.length || target < 0)
                return false;
            if(n == 0)
                return target == 0;

            int bound = nums.length - n;
            for(int i = start; i <= bound; i++) {
                if(dfs(nums, target - nums[i], i + 1, n - 1))
                    return true;
            }
            return false;
        }

        public int sum(int[] nums) {
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

    static class SolutionB {
        public boolean splitArraySameAverage(int[] A) {
            if(A == null || A.length <= 1)  return false;

            int sum = sum(A), len = A.length;
            if(sum == 0)    return true;

            boolean[][] map = new boolean[sum + 1][len + 1];

            for(int num : A) {
                for(int i = map.length - 1; i >= 0; i--) {
                    for(int j = 0; j < len; j++) {
                        if(map[i][j]) {
                            map[i + num][j + 1] = true;
                        }
                    }
                }
                map[num][1] = true;
            }

            for(int sumB = 1; sumB < sum; sumB++) {
                if(len * sumB % sum != 0)   continue;
                int count = len * sumB / sum;

                if(map[sumB][count])
                    return true;
            }

            return false;
        }

        public int sum(int[] nums) {
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

}
