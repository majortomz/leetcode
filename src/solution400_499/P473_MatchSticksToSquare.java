package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2018/01/10 19:03
 * Description:
 */
public class P473_MatchSticksToSquare {

    int edge;

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        edge = sum / 4;
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, edge, 1);
    }

    public boolean helper(int[] nums, boolean[] visited, int start, int sum, int count) {
        if (sum == 0) {
            if (count == 4) {
                boolean allVisited = true;
                for (boolean x : visited) {
                    if (!x) {
                        allVisited = false;
                        break;
                    }
                }
                return allVisited;
            } else {
                return helper(nums, visited, 0, edge, count + 1);
            }
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i] || sum < nums[i]) {
                continue;
            }
            visited[i] = true;
            if (helper(nums, visited, i + 1, sum - nums[i], count)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

}

// from leetcode discussion
class Solution2 {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        return dfs(nums, new int[4], 0, sum / 4);
    }

    public boolean dfs(int[] nums, int[] sums, int index, int target) {
        if(index ==  nums.length) {
            if(sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            } else {
                return false;
            }
        }

        for(int i = 0; i < 4; i++) {
            if(sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if(dfs(nums, sums, index + 1, target)) {
                return true;
            }
            sums[i] -= nums[index];
        }
        return false;
    }

}
