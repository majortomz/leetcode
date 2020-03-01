package solution800_899;

/**
 * Created by zjw on 2018/06/17 9:34
 * Description:
 */
public class P852_PeakIndex {

    // 题目指出 3 <= A.length <= 10000，而且peak不会再首尾出现
    public int peakIndexInMountainArray(int[] A) {
        int low = 0, high = A.length - 1;
        while(low <= high) {
            int mid = low + (high - low ) / 2;
            // 所以这里不会越界
            if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }

            if(A[mid - 1] < A[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
