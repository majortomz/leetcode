package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/01 16:13
 * Description: 旋转数组的最小数字
 */
public class Z06_MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        return array[array.length - 1];
    }

    public int minNumberInRotateArray2(int[] array) {
        if (array == null || array.length == 0) return 0;
        int lt = 0, rt = array.length - 1;
        while (lt < rt && array[lt] > array[rt]) {
            int mid = (rt + lt) / 2;
            if (array[mid] > array[rt]) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return array[lt];
    }

}
