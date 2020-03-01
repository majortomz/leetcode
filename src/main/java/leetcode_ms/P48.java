package leetcode_ms;

/**
 * Created by zjw on 2018/07/19 9:44
 * Description:
 */
public class P48 {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length, n = matrix[0].length;
        for(int i = m / 2 - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m - i - 1][j];
                matrix[m - i - 1][j] = tmp;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

    public void rotate2(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        for(int i = n / 2 - 1; i >= 0; i--) {
            for(int j = n - i - 2; j >= i; j--) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }

    }

}
