package solution400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/5/26.
 */
public class P442_FindAllDupsInArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int visited = 0, exist = -1;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == exist) continue;
            int pre = nums[i];
            nums[i] = visited;
            while(nums[pre - 1] != exist && nums[pre - 1] != visited) {
                int next = nums[pre - 1];
                nums[pre - 1] = exist;
                pre = next;
            }
            if(nums[pre - 1] == exist)
                list.add(pre);
            else
                nums[pre - 1] = exist;
        }
        return list;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] = -nums[index];
            else
                list.add(index + 1);
        }
        return list;
    }

}
