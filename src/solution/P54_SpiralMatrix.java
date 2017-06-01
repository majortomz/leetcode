package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/6/1.
 */
public class P54_SpiralMatrix {

    // [[1,2,3],[4,5,6],[7,8,9]]
    // [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
    // [[2,3]]
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)  return res;
        int rowNum = matrix.length, colNum = matrix[0].length, count = rowNum * colNum;
        int i = 0, j = -1, state = 0;
        boolean[][] visited = new boolean[rowNum][colNum];
        while(res.size() < count) {
            switch(state) {
                case 0: j++;    break;
                case 1: i++;    break;
                case 2: j--;    break;
                case 3: i--;    break;
            }
            if(j >= colNum || i >= rowNum || j < 0 || visited[i][j]) {
                if(state == 0)  j--;
                else if(state == 1) i--;
                else if(state == 2) j++;
                else if(state == 3) i++;
                state = (state + 1) % 4;
                continue;
            }
            visited[i][j] = true;
            res.add(matrix[i][j]);
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)  return res;
        int rowMin = 0, rowMax = matrix.length - 1, colMin = 0, colMax = matrix[0].length - 1;
        int i = 0, j = 0, count = matrix.length * matrix[0].length, state = 0;
        while(res.size() < count) {
            if(state == 0) {
                while(j <= colMax) {
                    res.add(matrix[i][j]);
                    j++;
                }
                i = rowMin = (rowMin + 1);
                j--;
            }
            else if(state == 1) {
                while(i <= rowMax) {
                    res.add(matrix[i][j]);
                    i++;
                }
                j = colMax = (colMax - 1);
                i--;
            }
            else if(state == 2) {
                while(j >= colMin) {
                    res.add(matrix[i][j]);
                    j--;
                }
                i = rowMax = (rowMax - 1);
                j++;
            }
            else {
                while(i >= rowMin) {
                    res.add(matrix[i][j]);
                    i--;
                }
                j = colMin = (colMin + 1);
                i++;
            }
            state = (state + 1) % 4;
        }
        return res;
    }
}
