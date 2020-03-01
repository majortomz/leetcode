package solution800_899;

/**
 * Created by zjw on 2018/07/01 10:13
 * Description:
 */
public class P861_ScoreFlippingMatrix {

    public int matrixScore(int[][] A) {

        int m = A.length, n = A[0].length;

        // record each column's number of 1
        int[] cols = new int[n];

        // 保证每行的高位为1
        for (int i = 0; i < m; i++) {
            int first = A[i][0];
            for (int j = 0; j < n; j++) {
                if(first == 0) {
                    A[i][j] = 1 - A[i][j];
                }
                if (A[i][j] == 1) {
                    cols[j] += 1;
                }
            }
        }

        // 保证每列的1数目占多数
        for (int j = 0; j < n; j++) {
            if (cols[j] >= m - cols[j]) {
                continue;
            }
            for (int i = 0; i < m; i++) {
                A[i][j] = 1 - A[i][j];
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp = (tmp | (A[i][j] << (n - j - 1)));
            }
            res += tmp;
        }
        return res;
    }

}
