package leetcode_ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/08/06 21:28
 * Description:
 */
public class P47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> path) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            helper(nums, visited, res, path);
            path.remove(path.size() - 1);
            visited[i] = false;
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
