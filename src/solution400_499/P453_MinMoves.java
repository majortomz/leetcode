package solution400_499;

/**
 * Created by zjw on 2018/02/01 17:00
 * Description:
 */
public class P453_MinMoves {

    // TLE
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        long max = Long.MIN_VALUE, min = Long.MAX_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        while ((nums.length * max - sum) % (nums.length - 1) != 0 || max - min > (nums.length * max - sum) / (nums.length - 1)) {
            max++;
        }
        return (int) ((nums.length * max - sum) / (nums.length - 1));
    }

    // m: m moves;  x: final equal num
    // n * x = sum + (n - 1) * m;   and x = minNum + m
    // then: m = sum - n * minNum
    public int minMoves2(int[] nums) {
        if(nums.length == 0)    return 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for(int num : nums) {
            res += num - min;
        }
        return res;
    }

}
