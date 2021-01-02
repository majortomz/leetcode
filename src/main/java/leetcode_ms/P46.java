package leetcode_ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/08/06 9:36
 * Description: permutations
 */
public class P46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }

        dfs(nums, nums.length - 1, res);
        return res;
    }

    public void dfs(int[] nums, int bound, List<List<Integer>> res) {
        if(bound <= 0) {
            List<Integer> list = new ArrayList<>();
            for(int num: nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for(int i = 0; i <= bound; i++) {
            swap(nums, i, bound);
            dfs(nums, bound - 1, res);
            swap(nums, i, bound);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
