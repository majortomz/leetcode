package pdd;

import java.util.Scanner;

/**
 * Created by zjw on 2018/08/05 19:38
 * Description:
 */
public class P3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        sc.nextLine();
        long[][] arr = new long[n][2];
        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for(String id: line.split("\\s+")) {
                int k = Integer.valueOf(id);
                if(k >= 64) {
                    arr[i][1] = (arr[i][1] | (1 << (k - 64)));
                } else {
                    arr[i][0] = (arr[i][0] | (1 << k));
                }
            }
        }

        int max = 0, res = -1;
        for(int i = 0; i < n; i++) {
            if(i == target) {
                continue;
            }

            if(i < 64 && (arr[target][0] & (1 << i)) != 0) {
                continue;
            }

            if(i >= 64 && (arr[target][1] & (1 << (i - 64))) != 0) {
                continue;
            }

            long a = arr[i][0] & arr[target][0], b = arr[i][1] & arr[target][1];
            int sum = count(a) + count(b);
            if(sum > max) {
                max = sum;
                res = i;
            }
        }
        System.out.println(res);
    }

    public static int count(long num) {
        int res = 0;
        for(int i = 0; i < 64; i++) {
            res += ((num >>> i) & 1);
        }
        return res;
    }

}
