package solution700_799;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/04 11:17
 * Description:
 */
public class P795_SubArrayWithBoundedMax {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if(A == null || A.length == 0)  return 0;
        int[] dp = Arrays.copyOf(A, A.length);
        int count = 0;
        for(int i = 1; i <= A.length; i++) {
            int[] tmp = new int[A.length - i + 1];
            for(int j = 0; j < tmp.length; j++) {
                tmp[j] = Math.max(dp[j], A[j + i - 1]);
                if(tmp[j] >= L && tmp[j] <= R)
                    count++;
            }
            dp = tmp;
        }
        return count;
    }

}
