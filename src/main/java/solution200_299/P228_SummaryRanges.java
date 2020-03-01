package solution200_299;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/6/10.
 */
public class P228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0)    return res;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1] + 1) {
                if(count > 1)
                    sb.append("->").append(nums[i-1]);
                res.add(sb.toString());
                sb = new StringBuilder();
                sb.append(nums[i]);
                count = 1;
            }
            else
                count++;
        }
        if(count > 1)
            sb.append("->").append(nums[nums.length - 1]);
        res.add(sb.toString());
        return res;
    }
}
