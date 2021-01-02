package solution800_899;

/**
 * Created by zjw on 2018/09/02 9:35
 * Description:
 */
public class P896_MonotonicArray {

    public boolean isMonotonic(int[] A) {
        int direct = 0;

        for(int i = 1; i < A.length; i++) {
            if(direct != 0 && (A[i] - A[i - 1]) * direct < 0) {
                return false;
            }
            if(direct == 0 && A[i] != A[i - 1]) {
                direct = A[i] > A[i - 1] ? 1 : -1;
            }
        }
        return true;
    }

}
