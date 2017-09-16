package solution500_599;

/**
 * Created by zjw on 2017/8/22.
 */
public class P576_OutOfBoundaryPaths {

    public int mod = (int)1e9 + 7, SIZE = 50;

    public int[][][] mat = new int[SIZE][SIZE][SIZE];
    public int[][] go = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int findPaths(int m, int n, int N, int i, int j) {
        if(N <= 0)  return 0;
        else if(mat[i][j][N] != 0)  return mat[i][j][N];

        int res = 0;
        for(int k = 0; k < go.length; k++) {
            int ni = i + go[k][0], nj = j + go[k][1];
            if(ni < 0 || ni >= m || nj < 0 || nj >= n)
                res += 1;
            else
                res += findPaths(m, n, N-1, ni, nj);
            res %= mod;
        }
        mat[i][j][N] = res;
        return res;
    }

    public int findPaths2(int m, int n, int N, int i, int j) {
        int mod = (int)1e9 + 7, L = 51;
        int[][] go = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][][] mat = new int[L][L][L];

        // result = sum([1 step, 2 step, ... , N step])
        for(int step = 1; step <= N; step++) {
            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    for(int k = 0; k < go.length; k++) {
                        int ni = x + go[k][0], nj = y + go[k][1];
                        if(ni < 0 || ni >= m || nj < 0 || nj >= n) {
                                mat[step][x][y]++;
                        }
                        else {
                            mat[step][x][y] += mat[step-1][ni][nj];
                        }
                        mat[step][x][y] %= mod;
                    }
                }
            }
        }

        return mat[N][i][j];
    }

}
