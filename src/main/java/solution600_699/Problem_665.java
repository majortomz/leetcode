package solution600_699;

/**
 * Created by zjw on 2018/03/24 11:08
 * Description:
 */
public class Problem_665 {

    public boolean checkPossibility(int[] nums) {
        int count = 1;
        for(int i = 1; i < nums.length && count >= 0; i++) {
            if(nums[i] < nums[i - 1]) {
                count--;
                if(i - 2 >= 0 && nums[i] < nums[i - 2])  nums[i] = nums[i - 1];
                else    nums[i - 1] = nums[i];
            }

        }
        return count >= 0;
    }
}
