package test;

import java.util.Scanner;

/**
 * Created by zjw on 2018/09/16 15:40
 * Description:
 */
public class Su_P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt(), y = sc.nextInt();
        long n = (long)Math.sqrt((x +y) * 2);
        if(n * (n + 1) / 2 != (x + y)) {
            System.out.println("-1");
            return;
        }

        int count = 0;
        for(long i = Math.min(x, n); i > 0; i--) {
            if(i <= x) {
                x -= i;
                count++;
            }
            if(x == 0) {
                break;
            }
        }

        if(x == 0) {
            System.out.println(count);
        } else {
            System.out.println("-1");
        }
    }

}
