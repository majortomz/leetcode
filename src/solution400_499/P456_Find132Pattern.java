package solution400_499;

import java.util.TreeSet;

/**
 * Created by zjw on 2018/02/02 14:19
 * Description:
 */
public class P456_Find132Pattern {

    // wrong answer
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min = nums[0], max = Integer.MIN_VALUE;
        int state = 1;
        int helper[] = new int[nums.length];
        helper[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            helper[i] = Math.min(helper[i - 1], nums[i - 1]);
            if (state == 1) {
                if (min > num) {
                    min = num;
                } else if (min < num) {
                    max = num;
                    state = 2;
                }
            } else {
                if (num == max) {
                    continue;
                }
                if (min < num && num < max) {
                    return true;
                } else if (num > max) {
                    max = num;
                    min = helper[i];
                } else {
                    // wrong [3 5 0 3 4] [3 5 0 1 3 2]
                    min = num;
                    state = 1;
                }
            }
        }
        return false;
    }

    // use treeSet
    public boolean find132pattern2(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        int[] min = new int[nums.length];
        TreeSet<Integer> treeSet = new TreeSet<>();
        min[0] = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i - 1], min[i - 1]);
        }

        for(int i = nums.length - 1; i > 0; i--) {
            treeSet.add(nums[i]);
            Integer mid = treeSet.lower(nums[i]);
            if(mid != null && mid < nums[i] && mid > min[i]) {
                return true;
            }
        }
        return false;
    }

    // Solution 2 : from leetcode discussion
    public boolean find132pattern3(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        int[] min = new int[nums.length], mid = new int[nums.length];
        min[0] = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i - 1], min[i - 1]);
        }

        mid[nums.length - 1] = Integer.MAX_VALUE;
        for(int i = nums.length - 2; i > 0; i--) {
            mid[i] = nums[i + 1] > min[i] ? Math.min(mid[i + 1], nums[i + 1]) : mid[i + 1];
            if(nums[i] > mid[i] && mid[i] > min[i])
                return true;
        }
        return false;
    }


}
