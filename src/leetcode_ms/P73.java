package leetcode_ms;

/**
 * Created by zjw on 2018/08/03 18:48
 * Description:
 */
public class P73 {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length, n = matrix[0].length;
        boolean tr = false, tc = false;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                tc = true;
            }
        }

        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                tr = true;
            }
        }

        // scan
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zero
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(tr) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(tc) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
