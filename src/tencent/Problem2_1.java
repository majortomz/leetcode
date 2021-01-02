package tencent;

import java.util.Scanner;

public class Problem2_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int lenA = in.nextInt();
        int countA = in.nextInt();
        int lenB = in.nextInt();
        int countB = in.nextInt();
        long res = 0;
        long[] A = new long[countA + 1];
        long[] B = new long[countB + 1];
        A[0] = 1;
        B[0] = 1;
        for (int i = 1; i <= countA; i++) {
            if (i * 2 > countA) {
                A[i] = A[countA - i];
            } else {
                A[i] = A[i - 1] * (countA - i + 1) / i;
            }
        }

        for (int i = 1; i <= countB; i++) {
            if (i * 2 > countB) {
                B[i] = B[countB - i];
            } else {
                B[i] = B[i - 1] * (countB - i + 1) / i;
            }
        }
        for (int i = 0; i * lenA <= k && i <= countA; i++) {
            int ret = k - i * lenA;
            if (ret % lenB == 0 && ret / lenB <= countB) {
                int j = ret / lenB;
                res += A[i] * B[j];
            }
        }
        System.out.println(res % 1000000007);

    }
}
