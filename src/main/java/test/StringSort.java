package test;

import java.util.Scanner;

/**
 * Created by zjw on 2018/08/11 16:14
 * Description:
 */
public class StringSort {


    public static int calC(int m, int n) {
        long a = 1, b = 1;
        for(int i = 1; i <= n; i++) {
            a *= n;
            b *= (m - i + 1);
        }
        return (int)(b / a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n, m , k;
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();

            StringBuilder sb = new StringBuilder();

            while(n != 0 && m != 0) {
                int fromA = calC(n + m - 1, n - 1);
                if(fromA >= k) {
                    sb.append('a');
                    n -= 1;
                } else {
                    sb.append('z');
                    m -= 1;
                    k -= fromA;
                }
            }
            if(n != 0) {
                for(int i = 1; i <= n; i++) {
                    sb.append('a');
                }
            }
            if(m != 0) {
                for(int i = 1; i <= m; i++) {
                    sb.append('z');
                }
            }

            if(sb.length() > 0)
                System.out.println(sb.toString());
            else
                System.out.println(-1);
            sc.nextLine();
        }

    }

}
