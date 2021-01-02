package solution200_299;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/6/10 15:49.
 */
public class P229_MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)    return res;
        int a[] = {nums[0], nums[0]}, count[] = new int[2];
        for(int i : nums) {
            if(i == a[0])
                count[0]++;
            else if(i == a[1])
                count[1]++;
            else if(count[0] == 0) {
                a[0] = i;
                count[0] = 1;
            }
            else if(count[1] == 0) {
                a[1] = i;
                count[1] = 1;
            }
            else {
                count[0]--;
                count[1]--;
            }
        }
        count[0] = count[1] = 0;
        for(int i : nums) {
            if(i == a[0])   count[0]++;
            else if(i == a[1])   count[1]++;
        }
        int i = 0;
        while(i < a.length) {
            if(count[i] > nums.length / 3)
                res.add(a[i]);
            i++;
        }
        return res;
    }
}
