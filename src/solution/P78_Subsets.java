package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2017/5/26.
 */
public class P78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++)
        {
            int size = res.size();
            for(int j = 0; j < size; j++)
            {
                List<Integer> listA = new ArrayList<>(res.get(j));
                listA.add(nums[i]);
                res.add(listA);
            }
        }
        return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        backTrack(res, list, nums, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        for(int i = index; i < nums.length; i++)
        {
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            res.add(newList);
            backTrack(res, newList, nums, i + 1);
        }
    }

}
