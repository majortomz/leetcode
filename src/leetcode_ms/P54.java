package leetcode_ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/07/17 10:42
 * Description:
 */
public class P54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        int rowMin = 0, rowMax = m - 1, colMin = 0, colMax = n - 1;
        int state = 0;
        while(rowMin <= rowMax && colMin <= colMax) {
            if(state == 0) {
                for(int j = colMin; j <= colMax; j++) {
                    res.add(matrix[rowMin][j]);
                }
                rowMin++;
                state = 1;
            } else if(state == 1) {
                for(int i = rowMin; i <= rowMax; i++) {
                    res.add(matrix[i][colMax]);
                }
                colMax--;
                state = 2;
            } else if(state == 2) {
                for(int j = colMax; j >= colMin; j--) {
                    res.add(matrix[rowMax][j]);
                }
                rowMax--;
                state = 3;
            } else {
                for(int i = rowMax; i >= rowMin; i--) {
                    res.add(matrix[i][colMin]);
                }
                colMin++;
                state = 0;
            }
        }
        return res;
    }

}
