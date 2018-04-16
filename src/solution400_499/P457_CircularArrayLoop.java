package solution400_499;

/**
 * Created by zjw on 2018/03/28 19:30
 * Description:
 */
public class P457_CircularArrayLoop {

    // slow fast pointer
    public boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length <= 1)    return false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)    continue;
            int slow = i, fast = i, count = 0;
            boolean forward = nums[i] > 0;
            boolean sameDir = true;
            do {
                int temp = slow;

                slow = (nums.length + slow + nums[slow]) % nums.length;

                if(forward && nums[fast] < 0 || !forward && nums[fast] > 0) {
                    sameDir = false;
                    break;
                }
                fast = (nums.length + fast + nums[fast]) % nums.length;

                if(forward && nums[fast] < 0 || !forward && nums[fast] > 0)  {
                    sameDir = false;
                    break;
                }
                fast = (nums.length + fast + nums[fast]) % nums.length;

                nums[temp] = 0;
                count++;
            } while(slow != fast);
            if(sameDir && count > 1) return true;
        }
        return false;
    }

}
