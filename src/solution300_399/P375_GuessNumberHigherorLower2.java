package solution300_399;

/**
 * Created by zjw on 2017/8/23.
 */
public class P375_GuessNumberHigherorLower2 {

    public int getMoneyAmount(int n) {
        if(n <= 1)  return 0;
        int[][] mat = new int[n+1][n+1];
        for(int i = 1; i < n; i++)
            mat[i][i+1] = i;
        for(int len = 3; len <= n; len++) {
            int pos = n - len + 1;
            for(int i = 1; i <= pos; i++) {
                int min, last = i + len - 1;
                min = i + mat[i+1][last];
                for(int k = i + 1; k < last; k++) {
                    min = Math.min(min, k + Math.max(mat[i][k-1],  mat[k+1][last]));
                }
                min = Math.min(min, mat[i][last-1] + last);
                mat[i][last] = min;
            }
        }
        return mat[1][n];
    }
}
