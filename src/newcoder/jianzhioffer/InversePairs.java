package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 10:09
 * Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 *  题目保证输入的数组中没有的相同的数字
 */
public class InversePairs {

    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)    return 0;
        int[] copy = new int[array.length];
        return helper(array, copy, 0, array.length - 1);
    }

    public int helper(int[] array, int[] copy, int low, int high) {
        if(low == high) {
            copy[low] = array[low];
            return 0;
        }

        int mid = (low + high) / 2;
        int leftCount = helper(array, copy, low, mid);
        int rightCount = helper(array, copy, mid + 1, high);
        int count = 0;
        int i = mid, j = high, k = high;
        while(i >= low && j > mid) {
            if(array[i] > array[j]) {
                count += (j - mid);
                copy[k--] = array[i--];
                if(count > 1000000007)
                    count %= 1000000007;
            } else {
                copy[k--] = array[j--];
            }
        }
        while(i >= low) {
            copy[k--] = array[i--];
        }
        while(j > mid) {
            copy[k--] = array[j--];
        }
        for(i = low; i <= high; i++) {
            array[i] = copy[i];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}
