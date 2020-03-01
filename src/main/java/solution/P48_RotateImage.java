package solution;

/**
 * Created by zjw on 2017/6/1 14:16.
 */
public class P48_RotateImage {

    // 先上下翻转，再转置
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length, mid = n / 2;
        for(int i = 0; i < mid; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[i][j], ni = n - i - 1;
                matrix[i][j] = matrix[ni][j];
                matrix[ni][j] = tmp;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
