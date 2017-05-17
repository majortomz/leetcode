package solution400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/5/17.
 */
public class P448_NumberDisappear {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            int pos = nums[i];
            while(nums[pos - 1] != pos)
            {
                int nextVal = nums[pos - 1];
                nums[pos - 1] = pos;
                pos = nextVal;
            }
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != i + 1)
                list.add(i + 1);
        }
        return list;
    }

    // Solution2: From leetcode discussion,
    /*
    The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
     In this way all the numbers that we have seen will be marked as negative. In the second iteration,
      if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
