package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] mas = new int[n][2];
        int[][] tasks = new int[m][2];
        for(int i = 0; i < n; i++) {
            mas[i][0] = sc.nextInt();
            mas[i][1] = sc.nextInt();
        }
        for(int i = 0; i < m; i++) {
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }

        Arrays.sort(mas, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]));
        Arrays.sort(tasks, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]));

        long count = 0, value = 0;
        int[] level = new int[100 + 1];

        for(int i = 0, j = 0; i < m; i++) {
            while(j < n && mas[j][0] >= tasks[i][0]) {
                level[mas[j++][1]]++;
            }
            for(int lev = tasks[i][1]; lev <= 100; lev++) {
                if(level[lev] > 0) {
                    count++;
                    value += (200 * tasks[i][0] + 3 * tasks[i][1]);
                    level[lev]--;
                    break;
                }
            }
        }
        System.out.println(count + " " + value);
    }
}
