package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 11:02
 * Description: 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        return helper(array, 0, array.length - 1, k);
    }

    private int helper(int[] array, int low, int high, int k) {
        if(low > high || array[low] > k || array[high] < k)    return 0;
        if(low == high)    return array[low] == k ? 1 : 0;
        int mid = low + (high - low) / 2;
        return helper(array, low, mid, k) + helper(array, mid + 1, high, k);
    }
}
