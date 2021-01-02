package newcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by zjw on 2018/03/02 17:16
 * Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0)  return list;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int code = 1;
        while(top <= bottom && left <= right) {
            if(code == 1) {
                for(int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            } else if(code == 2) {
                for(int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            } else if (code == 3) {
                for(int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            } else {
                for(int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

            code = code % 4 + 1;
        }
        return list;
    }

}
