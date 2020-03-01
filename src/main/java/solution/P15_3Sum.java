package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2017/6/8.
 */
public class P15_3Sum {

    // O(n^2*lg(n))
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 2)    return res;
        Arrays.sort(nums);
        int last = nums.length - 3, pre = nums[0] - 1;
        for(int i = 0; i <= last; i++) {
            if(nums[i] > 0) break;
            if(nums[i] == pre)
                continue;
            pre = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j-1])   continue;
                int target = -(nums[i] + nums[j]);
                if(binarySearch(nums, j+1, target)) {
                    Integer[] list = {nums[i], nums[j], target};
                    res.add(Arrays.asList(list));
                }
            }
        }
        return res;
    }

    public boolean binarySearch(int[] nums, int start, int target) {
        int end = nums.length - 1, mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if(nums[mid] == target)
                return true;
            else if(target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    // Solution2: from leetcode discussion O(n^2)
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 2)    return res;
        Arrays.sort(nums);
        int last = nums.length - 3, pre = nums[0] - 1;
        for(int i = 0; i <= last; i++) {
            if(nums[i] > 0) break;
            if(nums[i] == pre)  continue;
            pre = nums[i];
            int left = i + 1, right = nums.length - 1, sum = -nums[i];
            while(left < right) {
                if(nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(right > left && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] < sum)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }

}
