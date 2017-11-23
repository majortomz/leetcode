package solution300_399;

/**
 *
 * Created by zjw on 2017/11/23.
 */
public class P304_RangeSumQuery {

}

class NumMatrix {

    private int[][] matrix, sum;

    private int getSum(int row, int col) {
        if(row < 0 || col < 0)
            return 0;
        else
            return sum[row][col];
    }

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null) {
            return;
        }
        this.matrix = matrix;
        int height = matrix.length, width = matrix[0].length;
        sum = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int lt = getSum(i - 1, j - 1);
                int rt = getSum(i - 1, j);
                int lb = getSum(i, j - 1);
                sum[i][j] = matrix[i][j] + lb + rt - lt;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(this.matrix == null) return 0;
        int leftTop = getSum(row1 - 1, col1 - 1);
        int rightTop = getSum(row1 - 1, col2);
        int leftBottom = getSum(row2, col1 - 1);
        return sum[row2][col2] - leftBottom - rightTop + leftTop;
    }
}

class NumMatrix2 {
    private int[][] matrix, sum;

    public NumMatrix2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null) {
            return;
        }
        this.matrix = matrix;
        int height = matrix.length, width = matrix[0].length;
        sum = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int lt = 0, rt = 0, lb = 0;
                if(i > 0 && j > 0) {
                    lt = sum[i-1][j-1];
                }
                if(i > 0) rt = sum[i-1][j];
                if(j > 0) lb = sum[i][j-1];
                sum[i][j] = matrix[i][j] + lb + rt - lt;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(this.matrix == null) return 0;
        int leftTop = 0, rightTop = 0, leftBottom = 0;
        if(row1 > 0 && col1 > 0)
            leftTop = sum[row1 - 1][col1 - 1];
        if(row1 > 0) rightTop = sum[row1 - 1][col2];
        if(col1 > 0)
            leftBottom = sum[row2][col1-1];
        return sum[row2][col2] - leftBottom - rightTop + leftTop;
    }
}
