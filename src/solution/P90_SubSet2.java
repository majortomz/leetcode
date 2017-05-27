package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2017/5/26.
 */
public class P90_SubSet2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
         List<List<Integer>> res = new ArrayList<>();
         List<Integer> list = new ArrayList<>();
         res.add(list);
         backTrack(res, list, nums, 0);
         return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        int i = index;
        while(i < nums.length)
        {
            int j = i;
            List<Integer> preList = list;
            while(j < nums.length && nums[j] == nums[i])
                j++;
            while(i < j)
            {
                List<Integer> newList = new ArrayList<>(preList);
                newList.add(nums[i]);
                res.add(newList);
                backTrack(res, newList, nums, j);
                preList = newList;
                i++;
            }
        }
    }

}
