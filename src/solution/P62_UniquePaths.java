package solution;

/**
 * Created by zjw on 2017/5/31.
 */
public class P62_UniquePaths {

    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0)  return 0;
        int[] mat = new int[n];
        mat[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                mat[j] += mat[j-1];
            }
        }
        return mat[n-1];
    }

}
