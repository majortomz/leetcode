package solution;

/**
 * Created by zjw on 2017/5/27.
 */
public class P74_Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)    return false;
        int height = matrix.length, width = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[height - 1][width - 1])     return false;
        int row, lt = 0, rt = height - 1, mid;
        while(lt <= rt && matrix[lt][0] <= target)
            lt++;
        row = lt - 1;
        lt = 0;
        rt = width - 1;
        while(lt <= rt) {
            mid = (lt + rt) / 2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] < target)
                lt = mid + 1;
            else
                rt = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)    return false;
        int height = matrix.length, width = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[height - 1][width - 1])     return false;
        int lt = 0, rt = height * width - 1;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int m = mid / width, n = mid % width;
            if(matrix[m][n] == target)
                return true;
            else if(matrix[m][n] < target)
                lt = mid + 1;
            else
                rt = mid - 1;
        }
        return false;
    }

}
