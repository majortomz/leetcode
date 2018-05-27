package solution800_899;

/**
 * Created by zjw on 2018/05/13 9:38
 * Description:
 */
public class P832_FlipAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }

        int m = A.length, n = A[0].length;
        for(int i = 0; i < m; i++) {
            int mid = (n - 1) / 2;
            for(int j = 0; j <= mid; j++) {
                int tmp = A[i][j];
                A[i][j] = 1 - A[i][n - j - 1];
                A[i][n - j - 1] = 1 - tmp;
            }
        }

        return A;
    }

}
