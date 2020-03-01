package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2017/6/2.
 */
public class P40_CombinationSum2 {

    // 有点麻烦，其实数组中如果有重复数字的话，排序后直接计算第一个数字，剩余相同的数值直接跳过就好。
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return res;
        Arrays.sort(candidates);

        // candidates: [1, 1, 1, 2, 5, 6, 7, 8]
        // counts:     [3, 2, 1, 1, 1, 1, 2, 1]
        int[] counts = new int[candidates.length];
        counts[counts.length - 1] = 1;
        for(int i = counts.length - 2; i >= 0; i--)
            counts[i] = candidates[i] == candidates[i+1]? counts[i+1] + 1: 1;

        helper(candidates, counts, 0, 0, target, path, res);
        return res;
    }

    public void helper(int[] arr, int[] counts, int start, int sum, int target, List<Integer> path, List<List<Integer>> res) {

        for(int i = start; i < arr.length; i++) {
            int sum_new = sum + arr[i] * counts[i];
            if(sum_new > target)
                continue;

            for(int k = 1; k <= counts[i]; k++)
                path.add(arr[i]);

            if(sum_new == target) {
                List<Integer> tmp = new ArrayList<>(path);
                res.add(tmp);
            }
            else if (sum_new < target) {
                helper(arr, counts, i + counts[i], sum_new, target, path, res);
            }

            for(int k = 1; k <= counts[i]; k++)
                path.remove(path.size() - 1);
        }
    }

}
