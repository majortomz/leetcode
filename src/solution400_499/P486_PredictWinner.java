package solution400_499;

/**
 * Created by zjw on 2017/8/23.
 */
public class P486_PredictWinner {

    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length <= 1)    return true;
        return compare(nums, 0, 0, 0, nums.length-1, true);
    }

    public boolean compare(int[] nums, int sumA, int sumB, int lt, int rt, boolean who) {
        if(lt > rt) return sumA >= sumB;
        if(who) {
            return compare(nums, sumA + nums[lt], sumB, lt + 1, rt, false) ||
                    compare(nums, sumA + nums[rt], sumB, lt, rt-1, false);
        }
        else {
            return compare(nums, sumA, sumB + nums[lt], lt + 1, rt, true) ||
                    compare(nums, sumA, sumB + nums[rt], lt, rt-1, true);
        }
    }
}
