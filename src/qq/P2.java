package qq;

import java.util.Scanner;

/**
 * Created by zjw on 2018/09/16 10:45
 * Description:
 */
public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        boolean[][] mat = new boolean[n][n];
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(u != v) {
                mat[u - 1][v - 1]= true;
            }
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    mat[i][j] = mat[i][j] | (mat[i][k] & mat[k][j]);
                }
            }
        }

        int res = 0;
        int[] x = new int[n], y = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n ;j++) {
                if(mat[i][j]) {
                    x[i]++;
                    y[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(y[i] > x[i]) {
                res++;
            }
        }
        System.out.println(res);
    }

}
