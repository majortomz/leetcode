package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2017/9/21.
 */
public class P47_Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length == 0)    return res;

        Arrays.sort(nums);

        List<Integer> path = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        helper(res, path, nums, flag);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] flag) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(flag[i])  continue;

            path.add(nums[i]);
            flag[i] = true;
            helper(res, path, nums, flag);
            path.remove(path.size() - 1);
            flag[i] = false;

            while(i + 1 < nums.length && nums[i] == nums[i+1])
                i++;
        }
    }

}
