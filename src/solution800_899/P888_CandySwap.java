package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/19 9:38
 * Description:
 */
public class P888_CandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for(int num: A) {
            sumA += num;
        }
        for(int num: B) {
            sumB += num;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int target = (sumA - sumB) / 2;
        int[] res = new int[2];
        int i = 0, j = 0;
        while(i < A.length && j < B.length) {
            if(A[i] - B[j] == target) {
                res[0] = A[i];
                res[1] = B[j];
                break;
            } else if(A[i] - B[j] < target) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

}
