package solution500_599;

import java.util.Arrays;

/**
 * Created by zjw on 2017/5/23.
 */
public class P581_ShortestUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int lt = 0, rt = arr.length - 1, i = 0;
        while(lt < arr.length && nums[lt] == arr[lt]) {
            lt++;
        }
        while(rt >= lt && nums[rt] == arr[rt])
            rt--;
        return rt - lt + 1;
    }

}
