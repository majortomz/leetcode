package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/09 10:10
 * Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class DuplicateInArray {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers != null) {
            boolean[] dp = new boolean[numbers.length];
            for (int num : numbers) {
                if (dp[num]) {
                    duplication[0] = num;
                    return true;
                }
                dp[num] = true;
            }
        }
        duplication[0] = -1;
        return false;
    }
}
