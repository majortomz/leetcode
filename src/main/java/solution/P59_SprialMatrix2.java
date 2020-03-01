package solution;

/**
 * Created by zjw on 2017/6/1.
 */
public class P59_SprialMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        if(n <= 0)  return mat;
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int count = 0;
        while(left <= right && up <= down) {
            for(int j = left; j <= right; j++) {
                count++;
                mat[up][j] = count;
            }
            up++;

            for(int i = up; i <= down; i++) {
                count++;
                mat[i][right] = count;
            }
            right--;

            if(up <= down) {
                for(int j = right; j >= left; j--) {
                    count++;
                    mat[down][j] = count;
                }
                down--;
            }
            if(left <= right) {
                for(int i = down; i >= up; i--) {
                    count++;
                    mat[i][left] = count;
                }
                left++;
            }
        }
        return mat;
    }
}
