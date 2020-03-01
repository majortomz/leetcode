package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 10:03
 * Description: 153. Find Minimum in Rotated Sorted Array
 */
public class P153 {

    public int findMin(int[] array) {

        if(array == null || array.length == 0) {
            return 0;
        }

        int low = 0, high = array.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return array[low];
    }

}
