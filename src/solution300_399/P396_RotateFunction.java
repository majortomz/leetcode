package solution300_399;

/**
 * Created by zjw on 2018/01/26 11:14
 * Description:
 */
public class P396_RotateFunction {

    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }

        int sum = 0, max = 0;
        for(int i = 0; i < A.length; i++) {
            max += i * A[i];
            sum += A[i];
        }

        int curSum = max;
        for(int i = 1; i < A.length; i++) {
            curSum = curSum + sum - A.length * A[A.length - i];
            max = Math.max(max, curSum);
        }
        return max;
    }

}
