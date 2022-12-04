package solution1300_1399;

/**
 * Description:
 *
 * @author lanling.zjw date: 2020/03/08 00:30
 */
public class P1365_2 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] count = new int[101];
        int[] preSum = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= 100; i++) {
            preSum[i] = preSum[i - 1] + count[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = preSum[nums[i]];
        }

        return res;
    }

}
