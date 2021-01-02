package solution400_499;

import java.util.*;

/**
 * Created by zjw on 2017/12/14.
 */
public class P491_IncreasingSubsequence {

    // ac
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<List<Integer>>> arr = new ArrayList<>();
        boolean[][] visited = new boolean[201][201];

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            int indexA = nums[i] + 100;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    continue;
                }
                int indexB = nums[j] + 100;
                if(!visited[indexA][indexB]) {
                    tmp.add(Arrays.asList(nums[j], nums[i]));
                    visited[indexA][indexB] = true;
                }
                for (List<Integer> list : arr.get(j)) {
                    List<Integer> listNew = new ArrayList<>(list);
                    listNew.add(nums[i]);
                    tmp.add(listNew);
                }
                if(nums[j] == nums[i]) {
                    break;
                }
            }
            arr.add(tmp);
            result.addAll(tmp);
        }
        return result;
    }

    // ac
    public List<List<Integer>> findSubsequences2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        helper(set, nums, 0, path);
        return new ArrayList<>(set);
    }

    public void helper(Set<List<Integer>> set, int[] nums, int start, List<Integer> path) {
        if(start >= nums.length) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            path.add(nums[i]);
            if(path.size() >= 2) {
                set.add(new ArrayList<>(path));
            }
            helper(set, nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

}
