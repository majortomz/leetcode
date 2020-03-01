package solution;

/**
 * Created by zjw on 2017/5/29.
 */
public class P73_SetMatrixZeros {

    // O(m+n) Space
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return;
        int rm[] = new int[matrix.length], rn[] = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < rn.length; j++)
                if(matrix[i][j] == 0)
                {
                    rm[i] = 1;
                    rn[j] = 1;
                }
        for(int i = 0; i < rm.length; i++)
        {
            if(rm[i] == 0)  continue;
            for(int j = 0; j < rn.length; j++)
                matrix[i][j] = 0;
        }
        for(int i = 0; i < rn.length; i++)
        {
            if(rn[i] == 0)  continue;
            for(int j = 0; j < rm.length; j++)
                matrix[j][i] = 0;
        }
    }

    // Constant Space
    public void setZeroes2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return;
        boolean tr = false, tc = false;
        for(int i = 0; i < matrix[0].length; i++)
            if(matrix[0][i] == 0)
            {
                tr = true;
                break;
            }
        for(int i = 0; i < matrix.length; i++)
            if(matrix[i][0] == 0)
            {
                tc = true;
                break;
            }
        // scan
        for(int i = 1; i < matrix.length; i++)
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        // set zero
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(tr) {
            for(int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        if(tc) {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
