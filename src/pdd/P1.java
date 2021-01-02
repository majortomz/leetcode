package pdd;

import java.util.Scanner;

/**
 * Created by zjw on 2018/08/05 19:02
 * Description:
 */
public class P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int n = line.length() / 4 + 1;
        char[][] matrix = new char[n][n];

        int k = 0;
        for(int j = 0; j < n; j++) {
            matrix[0][j] = line.charAt(k++);
        }

        for(int i = 1; i <= n - 2; i++) {
            matrix[i][n - 1] = line.charAt(k++);
        }

        for(int j = n - 1; j >= 0; j--) {
            matrix[n - 1][j] = line.charAt(k++);
        }

        for(int i = n - 2; i >= 1; i--) {
            matrix[i][0] = line.charAt(k++);
        }

        System.out.println(new String(matrix[0]));

        for(int i = 1; i <= n - 2; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(matrix[i][0]);
            for(int j = 1; j <= n - 2; j++) {
                sb.append(" ");
            }
            sb.append(matrix[i][n - 1]);
            System.out.println(sb.toString());
        }

        System.out.println(new String(matrix[n - 1]));

    }

}
