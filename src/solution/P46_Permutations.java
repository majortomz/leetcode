package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/9/21.
 */
public class P46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length == 0)    return res;

        boolean[] flag = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();

        helper(res, path, flag, nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> path, boolean[] flag, int[] nums) {
        for(int i = 0; i < flag.length; i++) {
            if(flag[i]) continue;
            path.add(nums[i]);
            flag[i] = true;
            if(path.size() == flag.length) {
                res.add(new ArrayList<>(path));
            }
            else {
                helper(res, path, flag, nums);
            }
            path.remove(path.size()-1);
            flag[i] = false;
        }
    }

}
