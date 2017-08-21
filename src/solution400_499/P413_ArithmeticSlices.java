package solution400_499;

/**
 * Created by zjw on 2017/8/21 14:00.
 */
public class P413_ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)   return 0;
        int num = 0, start = 0;
        // notice that:  i <= A.length
        for(int i = 2; i <= A.length; i++) {
            if(i == A.length || A[i] - A[i - 1] != A[i - 1] - A[i - 2]) {
                int n = i - start;
                num += (n - 1) * (n - 2) / 2;
                start = i - 1;
            }
        }
        return num;
    }

}
