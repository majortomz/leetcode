package solution300_399;

/**
 * Created by zjw on 2017/8/1.
 */

class NumArray {

    int[][] sumArr;

    public NumArray(int[] nums) {
        sumArr = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            sumArr[i][i] = nums[i];
        }
        for(int i = 1; i < nums.length; i++) {
            for(int x = 0; x + i < nums.length; x++) {
                int y = x + i;
                sumArr[x][y] = sumArr[x][y-1] + sumArr[y][y];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumArr[i][j];
    }
}


public class P303_RangeSumQuery {

    class NumArray {

        int[] sumArr;

        public NumArray(int[] nums) {
            sumArr = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++) {
                sumArr[i+1] = sumArr[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sumArr[j+1] - sumArr[i];
        }
    }
}
